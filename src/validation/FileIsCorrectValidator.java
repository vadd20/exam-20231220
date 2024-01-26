package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import entity.PartyFromFile;
import enums.LogicError;

/**
 * Валидатор на наличие ошибок.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public class FileIsCorrectValidator {

    public static Boolean validate(List<PartyFromFile> partiesFromFile) {

        boolean isError = false;
        Set<String> ids = partiesFromFile.stream()
            .map(PartyFromFile::getId)
            .collect(Collectors.toSet());

        for (PartyFromFile partyFromFile : partiesFromFile) {

            var errors = new HashSet<LogicError>();
            List<Boolean> ruleIsValidResult =
                List.of(new IncorrectParentValidator().isValid(partyFromFile, errors, ids),
                    new IncorrectPartyNameValidator().isValid(partyFromFile, errors, ids),
                    new IncorrectPartyLevelValidator().isValid(partyFromFile, errors, ids)
                );

            if (ruleIsValidResult.contains(false)) {
                printError(partyFromFile.getId(), errors);
                isError = true;
            }
        }
        return isError;
    }

    private static void printError(String partyId, Set<LogicError> errors) {
        var sb = new StringBuilder();
        errors.forEach(e -> {
            sb.append(e.getDescription()).append("; ");
        });
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(partyId + ": " + sb);
    }
}

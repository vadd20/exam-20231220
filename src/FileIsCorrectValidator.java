import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import enums.LogicError;
import domain.PartyFromFile;

/**
 * Валидатор на наличие ошибок.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public class FileIsCorrectValidator {

    public static Boolean validate(List<PartyFromFile> partiesFromFile) {

        boolean isError = false;
        Map<String, List<String>> errors = new HashMap<>();
        Set<String> ids = partiesFromFile.stream()
            .map(PartyFromFile::getId)
            .collect(Collectors.toSet());

        for (PartyFromFile partyFromFile : partiesFromFile) {
            List<String> errorDescriptions = new ArrayList<>();
            if (!ids.contains(partyFromFile.getParent()) && partyFromFile.getParent() != null) {
                isError = true;
                errorDescriptions.add(LogicError.PARENT_IS_ABSENT_IN_CSV.getDescription());
                errors.put(partyFromFile.getId(), errorDescriptions);
            }
            if (partyFromFile.getName().length() > 255) {
                isError = true;
                errorDescriptions.add(LogicError.PARTY_NAME_MORE_255.getDescription());
                errors.put(partyFromFile.getId(), errorDescriptions);
            }
            if (!(partyFromFile.getLevel().equals("0") || partyFromFile.getLevel().equals("1"))) {
                isError = true;
                errorDescriptions.add(LogicError.PARTY_LEVER_IS_NOT_ZERO_OR_ONE.getDescription());
                errors.put(partyFromFile.getId(), errorDescriptions);
            }
        }
        printError(isError, errors);
        return isError;
    }

    private static void printError(Boolean isError, Map<String, List<String>> errors) {
        if (isError) {
            errors.forEach((k, v) -> {

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < v.size() - 1; i++) {
                    sb.append(v.get(i));
                    sb.append("; ");
                }
                sb.append(v.get(v.size() - 1));

                System.out.println(k + ": " + sb);
            });
        }
    }
}

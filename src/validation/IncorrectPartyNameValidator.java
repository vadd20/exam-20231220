package validation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import entity.PartyFromFile;
import enums.LogicError;

/**
 * Валидатор проверки корректного имени партии.
 *
 * @author Vadim Podogov
 * @since 2024.01.26
 */
public class IncorrectPartyNameValidator implements Rule {
    @Override
    public boolean isValid(PartyFromFile party, Set<LogicError> errors, Set<String> existingIds) {
        if (party.getName().length() > 255) {
            errors.add(LogicError.PARTY_NAME_MORE_255);
            return false;
        }
        return true;
    }
}

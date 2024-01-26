package validation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import entity.PartyFromFile;
import enums.LogicError;

/**
 * Валидатор проверки корректного уровня партии.
 *
 * @author Vadim Podogov
 * @since 2024.01.26
 */
public class IncorrectPartyLevelValidator implements Rule {
    @Override
    public boolean isValid(PartyFromFile party, Set<LogicError> errors, Set<String> existingIds) {
        if (!party.getLevel().equals("0") && !party.getLevel().equals("1")) {
            errors.add(LogicError.PARTY_LEVER_IS_NOT_ZERO_OR_ONE);
            return false;
        }
        return true;
    }
}

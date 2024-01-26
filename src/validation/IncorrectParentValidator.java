package validation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import entity.PartyFromFile;
import enums.LogicError;

/**
 * Валидатор проверки корректности родителя партии.
 *
 * @author Vadim Podogov
 * @since 2024.01.26
 */
public class IncorrectParentValidator implements Rule {
    @Override
    public boolean isValid(PartyFromFile party, Set<LogicError> errors, Set<String> ids) {
        if (!ids.contains(party.getParent()) && party.getParent() != null) {
            errors.add(LogicError.PARENT_IS_ABSENT_IN_CSV);
            return false;
        }
        return true;
    }

}

package validation;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import entity.PartyFromFile;
import enums.LogicError;

/**
 * Правило валидации.
 *
 * @author Vadim Podogov
 * @since 2024.01.26
 */
public interface Rule {
    boolean isValid(PartyFromFile party, Set<LogicError> errors, Set<String> existingIds);
}

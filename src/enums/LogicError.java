package enums;

/**
 * Перечисление ошибок.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public enum LogicError {
    PARENT_IS_ABSENT_IN_CSV("Встречаются записи, которые ссылаются на родителя, которого нет в csv"),
    PARTY_NAME_MORE_255("Название партии не умещается в 255 символов"),
    PARTY_LEVER_IS_NOT_ZERO_OR_ONE("Допустимый уровень партии 0 и 1");

    private final String description;
    LogicError(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

package enums;

/**
 * Перечисление Уровня партии.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public enum ActionLevel {

    FEDERAL("0", "FEDERAL"),
    REGIONAL("1", "REGIONAL");

    private final String code;
    private final String description;

    ActionLevel(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static ActionLevel getValueByCode(String code) {
        for (ActionLevel value : values()) {
            if (code.equals(value.code)) {
                return value;
            }
        }
        return null;
    }
}

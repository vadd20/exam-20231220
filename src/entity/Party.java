package entity;

import enums.ActionLevel;

/**
 * Модель политической партии.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public class Party {

    private final String uuid;
    private final String externalId;
    private final String name;
    private final ActionLevel actionLevel;
    private String parentId;
    private String partyCode;

    public Party(String uuid, String externalId, String name, ActionLevel actionLevel, String parentId,
                 String partyCode) {
        this.uuid = uuid;
        this.externalId = externalId;
        this.name = name;
        this.actionLevel = actionLevel;
        this.parentId = parentId;
        this.partyCode = partyCode;
    }

    public String getUuid() {
        return uuid;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }

    public ActionLevel getActionLevel() {
        return actionLevel;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }
}

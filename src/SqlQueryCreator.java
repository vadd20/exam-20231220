import java.util.List;
import domain.Party;

/**
 * Класс для создания SQL запроса и файла.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public class SqlQueryCreator {

    public static String createSqlQuery(List<Party> parties) {
        StringBuilder sb = new StringBuilder();
        sb.append(
            "INSERT INTO political_party(id, external_id, \"name\", action_level, parent_id, party_code) VALUES ");
        for (int i = 0; i < parties.size() - 1; i++) {
            appendValue(parties.get(i), sb);
            sb.append(", ");
        }
        appendValue(parties.get(parties.size() - 1), sb);
        sb.append(";");
        return sb.toString();
    }

    private static void appendValue(Party party, StringBuilder sb) {
        String comma = ", ";
        sb.append("(");
        sb.append("'").append(party.getUuid()).append("'").append(comma);
        sb.append(party.getExternalId()).append(comma);
        sb.append("'").append(party.getName()).append("'").append(comma);
        sb.append("'").append(party.getActionLevel().getDescription()).append("'").append(comma);
        if (party.getParentId() == null) {
            sb.append(party.getParentId()).append(comma);
        } else {
            sb.append("'").append(party.getParentId()).append("'").append(comma);
        }
        sb.append("'").append(party.getPartyCode()).append("'").append(")");
    }
}

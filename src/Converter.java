import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import domain.Party;
import domain.PartyFromFile;
import enums.ActionLevel;

/**
 * Конвертер для модели партии из файла в модель партии.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public class Converter {

    public static List<Party> convertPartyFromFileListToPartyList(List<PartyFromFile> partiesFromFile) {
        List<Party> parties = new ArrayList<>();
        Map<String, Party> externalIdToParty = partiesFromFile.stream()
            .map(partyFromFile -> new Party(
                UUID.randomUUID().toString(),
                partyFromFile.getId(),
                partyFromFile.getName(),
                ActionLevel.getValueByCode(partyFromFile.getLevel()),
                partyFromFile.getParent(),
                partyFromFile.getParent() == null ? partyFromFile.getCode() + "00" : partyFromFile.getCode()
            )).collect(Collectors.toMap(Party::getExternalId, Function.identity()));

        externalIdToParty.values().forEach(party -> {
            PartyFromFile parentPartyFromFile = partiesFromFile.stream()
                .filter(partyFromFile -> party.getParentId() != null)
                .filter(partyFromFile -> party.getParentId().equals(partyFromFile.getId()))
                .findFirst()
                .orElse(null);

            party.setParentId(
                parentPartyFromFile == null ? null : externalIdToParty.get(parentPartyFromFile.getId()).getUuid());

            if (parentPartyFromFile != null) {
                party.setPartyCode(
                    parentPartyFromFile.getCode() + party.getPartyCode());
            }
            parties.add(party);
        });

        return parties;
    }
}

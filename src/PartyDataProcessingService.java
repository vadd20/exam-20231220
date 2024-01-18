import java.io.IOException;
import java.util.List;
import domain.Party;

/**
 * Сервис обработки данных партий.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public class PartyDataProcessingService {

    public static void process() throws IOException {

        if (FileIsCorrectValidator.validate(FilePartyReader.getProcessedLines())) {
            return;
        }
        List<Party> parties = Converter.convertPartyFromFileListToPartyList(FilePartyReader.getProcessedLines());
        String stringQuery = SqlQueryCreator.createSqlQuery(parties);
        SqlQueryCreator.createSqlFile(stringQuery);
    }



}

import java.io.IOException;
import java.util.List;
import entity.Party;
import io.DataLoader;
import io.PartiesInformationWriter;
import io.SqlQueryWriter;
import validation.FileIsCorrectValidator;

/**
 * Основной класс.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public class Main {
    public static void main(String[] args) throws IOException {

        if (FileIsCorrectValidator.validate(DataLoader.getProcessedLines())) {
            return;
        }
        List<Party> parties = Converter.convertPartyFromFileListToPartyList(DataLoader.getProcessedLines());

        String stringQuery = SqlQueryCreator.createSqlQuery(parties);
        SqlQueryWriter.createSqlFile(stringQuery);

        PartiesInformationWriter.writeInformationToConsole(parties);
    }
}

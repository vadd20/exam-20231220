import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import domain.PartyFromFile;

/**
 * Класс для прочтения файла.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public class FilePartyReader {

    public static String FILE_PATH = "src\\party_example.csv";

    public static List<PartyFromFile> getProcessedLines() throws IOException {
        // создаем список партий из файла
        List<PartyFromFile> partiesFromFile = new ArrayList<>();
        String sep = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(sep);
                PartyFromFile partyFromFile = new PartyFromFile();
                partyFromFile.setId(rowData[0]);
                partyFromFile.setName(rowData[1]);
                partyFromFile.setLevel(rowData[2]);
                partyFromFile.setCode(rowData[3]);
                if (rowData.length < 5) {
                    partyFromFile.setParent(null);
                } else {
                    partyFromFile.setParent(rowData[4]);
                }
                partiesFromFile.add(partyFromFile);
            }
        }

        return partiesFromFile;
    }


}

package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import entity.PartyFromFile;

/**
 * Класс для чтения файла и загрузки данных.
 *
 * @author Vadim Podogov
 * @since 2024.01.18
 */
public class DataLoader {

    public static String FILE_PATH = "src\\data\\party_example.csv";

    public static List<PartyFromFile> getProcessedLines() throws IOException {
        List<PartyFromFile> partiesFromFile = new ArrayList<>();
        String sep = ",";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH)))) {
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

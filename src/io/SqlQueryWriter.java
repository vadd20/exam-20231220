package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Запись результата в SQL-файл.
 *
 * @author Vadim Podogov
 * @since 2024.01.26
 */
public class SqlQueryWriter {

    public static final String INPUT_FILENAME = "src\\insert_parties.sql";

    public static void createSqlFile(String query) throws IOException {
        try (var bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(INPUT_FILENAME)))) {
            bw.write(query);
        }
    }
}

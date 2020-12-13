package de.exxcellent.challenge.TableFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileReader {

    public static final String DELIMITER_REGEX = "([,;])";

    public CSVFileReader(String s) {

    }

    public static List<String[]> readCSV(String path) {
        return readCSV(path, false);
    }

    public static List<String[]> readCSV(String path, boolean skipHeader) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            return br
                    .lines()
                    .skip(skipHeader ? 1 : 0)
                    .map(line -> line.split(DELIMITER_REGEX))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

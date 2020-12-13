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
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            return br
                    .lines()
                    .map(line -> line.split(DELIMITER_REGEX))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

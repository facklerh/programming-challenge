package de.exxcellent.challenge.TableFileReader;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CSVFileReaderTest {

    public static final String TEST_CSV_PATH = "src/test/resources/test.csv";

    @Test
    void canReadCSVCorrectly() {
        List<String[]> result = CSVFileReader.readCSV(TEST_CSV_PATH);

        assertEquals(3, result.size());

        assertEquals(result.get(0).length, 2);
        assertEquals(result.get(0)[0], "row");
        assertEquals(result.get(0)[1], "data");

        assertEquals(result.get(1).length, 2);
        assertEquals(result.get(1)[0], "0");
        assertEquals(result.get(1)[1], "1");

        assertEquals(result.get(2).length, 2);
        assertEquals(result.get(2)[0], "1");
        assertEquals(result.get(2)[1], "2");
    }
}
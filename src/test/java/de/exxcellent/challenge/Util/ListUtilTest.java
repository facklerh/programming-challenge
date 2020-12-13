package de.exxcellent.challenge.Util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListUtilTest {
    @Test
    void canFindMinimumFromList() {
        List<Integer> testData = new ArrayList<>();
        testData.add(5);
        testData.add(30);
        testData.add(-1);
        testData.add(12);

        assertEquals(-1, ListUtil.findMinimum(testData, Integer::doubleValue));
    }
}
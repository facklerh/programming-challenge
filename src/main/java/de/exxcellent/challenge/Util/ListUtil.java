package de.exxcellent.challenge.Util;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ListUtil {
    public static <T> T findMinimum(List<T> testData, Function<T, Double> valueOf) {
        Optional<T> min = testData.stream().min(Comparator.comparingDouble(valueOf::apply));
        return min.orElse(null);
    }
}

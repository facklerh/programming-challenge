package de.exxcellent.challenge.WeatherData;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherDataFactory {
    // TODO: Convert to enum
    static final int DAY_IDX = 0;
    static final int MAX_TEMPERATURE_IDX = DAY_IDX + 1;
    static final int MIN_TEMPERATURE_IDX = MAX_TEMPERATURE_IDX + 1;
    // TODO: replace with enum values length
    public static final int DAILYWEATHERDATA_LENGTH = 14;


    public static List<DailyWeatherData> createWeatherData(List<String[]> monthlyData) {
        return monthlyData.stream().map(WeatherDataFactory::createWeatherData).collect(Collectors.toList());
    }

    public static DailyWeatherData createWeatherData(String[] dailyData) {
        if (dailyData.length != DAILYWEATHERDATA_LENGTH) {
            throw new IllegalArgumentException();
        }

        int day = Integer.parseInt(dailyData[DAY_IDX]);
        double minTemperature = Double.parseDouble(dailyData[MIN_TEMPERATURE_IDX]);
        double maxTemperature = Double.parseDouble(dailyData[MAX_TEMPERATURE_IDX]);

        return new DailyWeatherData.Builder()
                .withDay(day)
                .withMinTemperature(minTemperature)
                .withMaxTemperature(maxTemperature)
                .build();
    }
}

package de.exxcellent.challenge.WeatherData;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.exxcellent.challenge.WeatherData.WeatherDataFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherDataFactoryTest {
    @Test
    void canCreateDailyWeatherDataCorrectlyFromList() {
        List<String[]> testData = prepareDataList();

        List<DailyWeatherData> weatherData = createWeatherData(testData);

        assertEquals(testData.size(), weatherData.size());
    }

    @Test
    void canCreateDailyWeatherDataCorrectly() {
        String[] testData = prepareData();

        DailyWeatherData weatherData = createWeatherData(testData);

        assertEquals(Integer.parseInt(testData[DAY_IDX]), weatherData.getDay());
        assertEquals(Double.parseDouble(testData[MIN_TEMPERATURE_IDX]), weatherData.getMinTemperature());
        assertEquals(Double.parseDouble(testData[MAX_TEMPERATURE_IDX]), weatherData.getMaxTemperature());
    }

    private List<String[]> prepareDataList() {
        List<String[]> result = new ArrayList<>();
        result.add(prepareData());
        result.add(prepareData());
        result.add(prepareData());
        return result;
    }

    private String[] prepareData() {
        String[] result = new String[DAILYWEATHERDATA_LENGTH];
        result[DAY_IDX] = "1";
        result[MIN_TEMPERATURE_IDX] = "0";
        result[MAX_TEMPERATURE_IDX] = "30";
        return result;
    }

}
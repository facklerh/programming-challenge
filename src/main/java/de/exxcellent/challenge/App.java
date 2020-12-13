package de.exxcellent.challenge;

import de.exxcellent.challenge.TableFileReader.CSVFileReader;
import de.exxcellent.challenge.Util.ListUtil;
import de.exxcellent.challenge.WeatherData.DailyWeatherData;
import de.exxcellent.challenge.WeatherData.WeatherDataFactory;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …

        List<String[]> data = CSVFileReader.readCSV("src/main/resources/de/exxcellent/challenge/weather.csv", true);
        List<DailyWeatherData> weatherData = WeatherDataFactory.createWeatherData(data);
        DailyWeatherData smallestTemperatureSpread =
                ListUtil.findMinimum(weatherData, dWD -> dWD.getMaxTemperature() - dWD.getMinTemperature());

        System.out.printf("Day with smallest temperature spread : %s%n", smallestTemperatureSpread.getDay());

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}

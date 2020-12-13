package de.exxcellent.challenge;

import de.exxcellent.challenge.Data.Football.FootballDataFactory;
import de.exxcellent.challenge.Data.Football.FootballTeamData;
import de.exxcellent.challenge.Data.Weather.DailyWeatherData;
import de.exxcellent.challenge.Data.Weather.WeatherDataFactory;
import de.exxcellent.challenge.TableFileReader.CSVFileReader;
import de.exxcellent.challenge.Util.ListUtil;

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

        List<String[]> rawWeatherData = CSVFileReader.readCSV("src/main/resources/de/exxcellent/challenge/weather.csv", true);
        List<DailyWeatherData> weatherData = WeatherDataFactory.createWeatherData(rawWeatherData);
        DailyWeatherData smallestTemperatureSpread =
                ListUtil.findMinimum(weatherData, dWD -> dWD.getMaxTemperature() - dWD.getMinTemperature());

        System.out.printf("Day with smallest temperature spread : %s%n", smallestTemperatureSpread.getDay());

        List<String[]> rawFootballData = CSVFileReader.readCSV("src/main/resources/de/exxcellent/challenge/football.csv", true);
        List<FootballTeamData> footballTeamData = FootballDataFactory.createFootballTeamData(rawFootballData);
        FootballTeamData smallestDifference = ListUtil.findMinimum(footballTeamData, fTD ->
                Double.valueOf(fTD.getGoals() > fTD.getGoalsAllowed()
                        ? fTD.getGoals() - fTD.getGoalsAllowed()
                        : fTD.getGoalsAllowed() - fTD.getGoals())
        );

        System.out.printf("Team with smallest goal spread       : %s%n", smallestDifference.getName());
    }
}

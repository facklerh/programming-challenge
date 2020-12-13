package de.exxcellent.challenge.Data.Football;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.exxcellent.challenge.Data.Football.FootballDataFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FootballDataFactoryTest {
    @Test
    void canCreateDailyWeatherDataCorrectlyFromList() {
        List<String[]> testData = prepareDataList();

        List<FootballTeamData> weatherData = createFootballTeamData(testData);

        assertEquals(testData.size(), weatherData.size());
    }

    @Test
    void canCreateDailyWeatherDataCorrectly() {
        String[] testData = prepareData();

        FootballTeamData weatherData = createFootballTeamData(testData);

        assertEquals(testData[TEAM_NAME_IDX], weatherData.getName());
        assertEquals(Integer.parseInt(testData[GOALS_IDX]), weatherData.getGoals());
        assertEquals(Integer.parseInt(testData[GOALS_ALLOWED_IDX]), weatherData.getGoalsAllowed());
    }

    private List<String[]> prepareDataList() {
        List<String[]> result = new ArrayList<>();
        result.add(prepareData());
        result.add(prepareData());
        result.add(prepareData());
        return result;
    }

    private String[] prepareData() {
        String[] result = new String[FOOTBALLTEAMDATA_LENGTH];
        result[TEAM_NAME_IDX] = "Arsenal";
        result[GOALS_IDX] = "0";
        result[GOALS_ALLOWED_IDX] = "30";
        return result;
    }
}
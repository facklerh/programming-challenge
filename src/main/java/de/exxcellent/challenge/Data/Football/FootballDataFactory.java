package de.exxcellent.challenge.Data.Football;

import java.util.List;
import java.util.stream.Collectors;

public class FootballDataFactory {
    // TODO: Convert to enum
    static final int TEAM_NAME_IDX = 0;
    static final int GOALS_IDX = 5;
    static final int GOALS_ALLOWED_IDX = GOALS_IDX + 1;
    // TODO: replace with enum values length
    public static final int FOOTBALLTEAMDATA_LENGTH = 8;


    public static List<FootballTeamData> createFootballTeamData(List<String[]> teamDataList) {
        return teamDataList.stream().map(FootballDataFactory::createFootballTeamData).collect(Collectors.toList());
    }

    public static FootballTeamData createFootballTeamData(String[] teamData) {
        if (teamData.length != FOOTBALLTEAMDATA_LENGTH) {
            throw new IllegalArgumentException();
        }

        String name = teamData[TEAM_NAME_IDX];
        int goals = Integer.parseInt(teamData[GOALS_IDX]);
        int goalsAllowed = Integer.parseInt(teamData[GOALS_ALLOWED_IDX]);

        return new FootballTeamData.Builder()
                .withName(name)
                .withGoals(goals)
                .withGoalsAllowed(goalsAllowed)
                .build();
    }
}

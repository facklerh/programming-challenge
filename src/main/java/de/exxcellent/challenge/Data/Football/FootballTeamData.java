package de.exxcellent.challenge.Data.Football;

public class FootballTeamData {
    private String name;
    private int goals;
    private int goalsAllowed;

    public FootballTeamData(Builder builder) {
        this.name = builder.name;
        this.goals = builder.goals;
        this.goalsAllowed = builder.goalsAllowed;
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    static class Builder {
        private String name;
        private int goals;
        private int goalsAllowed;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withGoals(int goals) {
            this.goals = goals;
            return this;
        }

        public Builder withGoalsAllowed(int goalsAllowed) {
            this.goalsAllowed = goalsAllowed;
            return this;
        }

        public FootballTeamData build() {
            return new FootballTeamData(this);
        }
    }
}

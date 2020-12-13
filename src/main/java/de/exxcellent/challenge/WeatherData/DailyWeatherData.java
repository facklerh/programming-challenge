package de.exxcellent.challenge.WeatherData;

public class DailyWeatherData {
    private int day;
    private double minTemperature;
    private double maxTemperature;

    private DailyWeatherData(DailyWeatherData.Builder builder) {
        this.day = builder.day;
        this.minTemperature = builder.minTemperature;
        this.maxTemperature = builder.maxTemperature;
    }

    public int getDay() {
        return day;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    static class Builder {
        private int day;
        private double minTemperature;
        private double maxTemperature;

        public Builder withDay(int day) {
            this.day = day;
            return this;
        }

        public Builder withMinTemperature(double minTemperature) {
            this.minTemperature = minTemperature;
            return this;
        }

        public Builder withMaxTemperature(double maxTemperature) {
            this.maxTemperature = maxTemperature;
            return this;
        }

        public DailyWeatherData build() {
            return new DailyWeatherData(this);
        }
    }
}

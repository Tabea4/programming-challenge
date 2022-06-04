package de.exxcellent.challenge;

public class WeatherDayData {
    private int day;
    private int maximumTemperature;
    private int minimumTemperature;

    public WeatherDayData(int day, int maximumTemperature, int minimumTemperature) {
        this.day = day;
        this.maximumTemperature = maximumTemperature;
        this.minimumTemperature = minimumTemperature;
    }

    public int getMaximumTemperature() {
        return this.maximumTemperature;
    }

    public int getMinimumTemperature() {
        return this.minimumTemperature;
    }

    public String toString() {
        return String.valueOf(this.day);
    }
}

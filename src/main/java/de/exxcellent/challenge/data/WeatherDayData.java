package de.exxcellent.challenge.data;

public class WeatherDayData implements DifferenceInterface {
    private int day;
    private int maximumTemperature;
    private int minimumTemperature;

    public WeatherDayData(int day, int maximumTemperature, int minimumTemperature) {
        this.day = day;
        this.maximumTemperature = maximumTemperature;
        this.minimumTemperature = minimumTemperature;
    }

    public int getMaximumValue() {
        return this.maximumTemperature;
    }

    public int getMinimumValue() {
        return this.minimumTemperature;
    }

    public String toString() {
        return String.valueOf(this.day);
    }
}

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

    public int getFirstValue() {
        return this.maximumTemperature;
    }

    public int getSecondValue() {
        return this.minimumTemperature;
    }

    public String toString() {
        return String.valueOf(this.day);
    }
}

package de.exxcellent.challenge;

public class CompareByDifference implements java.util.Comparator<WeatherDayData> {
    @Override
    public int compare(WeatherDayData weatherDayData1, WeatherDayData weatherDayData2) {
        int differenceTemperatureWeatherDayData1 = weatherDayData1.getMaximumTemperature() - weatherDayData1.getMinimumTemperature();
        int differenceTemperatureWeatherDayData2 = weatherDayData2.getMaximumTemperature() - weatherDayData2.getMinimumTemperature();

        return Integer.compare(differenceTemperatureWeatherDayData1, differenceTemperatureWeatherDayData2);
    }
}

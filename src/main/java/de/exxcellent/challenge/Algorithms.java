package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithms {

    private CompareByDifference compareByDifference;

    public Algorithms() {
       this.compareByDifference = new CompareByDifference();
    }
    public List<WeatherDayData> getMinimumDifference(List<WeatherDayData> weatherDayDataList) {
        if (weatherDayDataList.isEmpty()) {
            return new ArrayList<>();
        }
        else {
            return getWeatherDayDataMinimumDifference(weatherDayDataList);
        }
    }

    private List<WeatherDayData> getWeatherDayDataMinimumDifference(List<WeatherDayData> weatherDayDataList) {
        weatherDayDataList.sort(this.compareByDifference);

        WeatherDayData oneWeatherDayDataWithMinimumDifference = getOneElementWithSmallestDifference(weatherDayDataList);

        return filterForAllElementsWithMinimumDifference(weatherDayDataList, oneWeatherDayDataWithMinimumDifference);
    }

    private WeatherDayData getOneElementWithSmallestDifference(List<WeatherDayData> weatherDayDataList) {
        return weatherDayDataList.get(0);
    }

    private List<WeatherDayData> filterForAllElementsWithMinimumDifference(List<WeatherDayData> weatherDayDataList, WeatherDayData oneWeatherDayDataWithMinimumDifference) {
        return weatherDayDataList.stream()
                          .filter( weatherDayData -> this.compareByDifference.compare(weatherDayData, oneWeatherDayDataWithMinimumDifference) == 0)
                          .collect(Collectors.toList());
    }

    public List<FootballData> getMinimumDifferenceFootball(List<FootballData> footballDataList) {
        return null;
    }
}

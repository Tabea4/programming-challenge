package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithms {

    private CompareByDifference compareByDifference;

    public Algorithms() {
       this.compareByDifference = new CompareByDifference();
    }
    public List<WeatherDayData> getMaximumDifference(List<WeatherDayData> weatherDayDataList) {
        if (weatherDayDataList.isEmpty()) {
            return new ArrayList<>();
        }
        else {
            return getWeatherDayDataMaximumDifference(weatherDayDataList);
        }
    }

    private List<WeatherDayData> getWeatherDayDataMaximumDifference(List<WeatherDayData> weatherDayDataList) {
        weatherDayDataList.sort(this.compareByDifference);

        WeatherDayData oneWeatherDayDataWithMaximumDifference = getOneElementWithHighestDifference(weatherDayDataList);

        return filterForAllElementsWithMaximumDifference(weatherDayDataList, oneWeatherDayDataWithMaximumDifference);
    }

    private WeatherDayData getOneElementWithHighestDifference(List<WeatherDayData> weatherDayDataList) {
        return weatherDayDataList.get(weatherDayDataList.size() - 1);
    }

    private List<WeatherDayData> filterForAllElementsWithMaximumDifference(List<WeatherDayData> weatherDayDataList, WeatherDayData oneWeatherDayDataWithMaximumDifference) {
        return weatherDayDataList.stream()
                          .filter( weatherDayData -> this.compareByDifference.compare(weatherDayData, oneWeatherDayDataWithMaximumDifference) == 0)
                          .collect(Collectors.toList());
    }
}

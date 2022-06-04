package de.exxcellent.challenge;

import java.util.Arrays;
import java.util.List;

public class DifferenceService {
    public String calculateSmallestTempSpread(String fileName) {
        CSVReaderWeather csvReaderWeather = new CSVReaderWeather(fileName);
        List<WeatherDayData> weatherDayDataList = csvReaderWeather.readData();
        Algorithms algorithms = new Algorithms();
        List<WeatherDayData> daysWithSmallestTempSpreadList = algorithms.getMaximumDifference(weatherDayDataList);

        String daysWithSmallestTempSpread = Arrays.toString(daysWithSmallestTempSpreadList.toArray());
        return "Day with smallest temperature spread : " + daysWithSmallestTempSpread;
    }
}

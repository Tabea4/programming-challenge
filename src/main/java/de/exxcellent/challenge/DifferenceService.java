package de.exxcellent.challenge;

import java.io.IOException;
import java.util.List;

public class DifferenceService {
    public String calculateSmallestTempSpread(String fileName) throws IOException {
        CSVReaderWeather csvReaderWeather = new CSVReaderWeather(fileName);
        List<WeatherDayData> weatherDayDataList = csvReaderWeather.createWeatherDataDayListFromFile();
        Algorithms algorithms = new Algorithms();
        List<WeatherDayData> daysWithSmallestTempSpreadList = algorithms.getMinimumDifference(weatherDayDataList);

        return formatResultString(daysWithSmallestTempSpreadList);
    }

    public String calculateSmallestGoalSpread(String fileName) {
        CSVReaderFootball csvReaderFootball = new CSVReaderFootball(fileName);
        List<FootballData> footballDataList = csvReaderFootball.createFootballDataListFromFile();
        Algorithms algorithms = new Algorithms();
        List<FootballData> teamsWithSmallestGoalSpreadList = algorithms.getMinimumDifferenceFootball(footballDataList);

        return formatResultStringFootball(teamsWithSmallestGoalSpreadList);
    }

    private String formatResultString(List<WeatherDayData> daysWithSmallestTempSpreadList) {
        StringBuilder resultString = new StringBuilder("Day(s) with smallest temperature spread :");

        for ( WeatherDayData dayWithSmallestTemp: daysWithSmallestTempSpreadList ) {
            resultString.append(" ").append(dayWithSmallestTemp);
        }

        return resultString.toString();
    }

    private String formatResultStringFootball(List<FootballData> teamsWithSmallestGoalSpreadList) {
        return "Team(s) with smallest goal spread : ";
    }
}

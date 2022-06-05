package de.exxcellent.challenge;

import java.io.IOException;
import java.util.List;

public class DifferenceService {
    public String calculateSmallestTempSpread(String fileName) throws IOException {
        CSVReader csvReaderWeather = new CSVReaderWeather(fileName);
        List<DifferenceInterface> weatherDayDataList = csvReaderWeather.createDataListFromFile();
        Algorithms algorithms = new Algorithms();
        List<DifferenceInterface> daysWithSmallestTempSpreadList = algorithms.getMinimumDifference(weatherDayDataList);

        return formatResultString(daysWithSmallestTempSpreadList);
    }

    public String calculateSmallestGoalSpread(String fileName) throws IOException {
        CSVReader csvReaderFootball = new CSVReaderFootball(fileName);
        List<DifferenceInterface> footballDataList = csvReaderFootball.createDataListFromFile();
        Algorithms algorithms = new Algorithms();
        List<DifferenceInterface> teamsWithSmallestGoalSpreadList = algorithms.getMinimumDifferenceFootball(footballDataList);

        return formatResultStringFootball(teamsWithSmallestGoalSpreadList);
    }

    private String formatResultString(List<DifferenceInterface> dataWithSmallestDifferenceList) {
        StringBuilder resultString = new StringBuilder("Day(s) with smallest temperature spread :");

        for ( DifferenceInterface dayWithSmallestTemp: dataWithSmallestDifferenceList ) {
            resultString.append(" ").append(dayWithSmallestTemp);
        }

        return resultString.toString();
    }

    private String formatResultStringFootball(List<DifferenceInterface> dataWithSmallestDifferenceList) {
        return "Team(s) with smallest goal spread : ";
    }
}

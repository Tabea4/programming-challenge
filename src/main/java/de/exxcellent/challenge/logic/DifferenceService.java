package de.exxcellent.challenge.logic;

import de.exxcellent.challenge.data.DifferenceInterface;
import de.exxcellent.challenge.reader.CSVReader;
import de.exxcellent.challenge.reader.CSVReaderFootball;
import de.exxcellent.challenge.reader.CSVReaderWeather;

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
        List<DifferenceInterface> teamsWithSmallestGoalSpreadList = algorithms.getMinimumDifference(footballDataList);

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
        StringBuilder resultString = new StringBuilder("Team(s) with smallest goal spread :");

        for ( DifferenceInterface teamWithSmallestGoalSpread: dataWithSmallestDifferenceList ) {
            resultString.append(" ").append(teamWithSmallestGoalSpread);
        }

        return resultString.toString();
    }
}

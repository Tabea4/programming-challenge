package de.exxcellent.challenge.logic;

import de.exxcellent.challenge.data.DifferenceInterface;
import de.exxcellent.challenge.reader.CSVReader;
import de.exxcellent.challenge.reader.CSVReaderFootball;
import de.exxcellent.challenge.reader.CSVReaderWeather;

import java.io.IOException;
import java.util.List;

public class DifferenceService {

    private Algorithms algorithms;

    public DifferenceService() {
        algorithms = new Algorithms();
    }

    public String calculateSmallestDifference(String context, String fileName) throws IOException {
        String result;

        if ( context.equalsIgnoreCase("--football") ) {
            result = calculateSmallestGoalSpread(fileName);
        } else if (context.equalsIgnoreCase("--weather")) {
            result = calculateSmallestTempSpread(fileName);
        }
        else {
            throw new IllegalArgumentException("Wrong context, only football and weather are supported");
        }

        return result;
    }
    private String calculateSmallestTempSpread(String fileName) throws IOException {
        CSVReader csvReaderWeather = new CSVReaderWeather(fileName);
        List<DifferenceInterface> weatherDayDataList = csvReaderWeather.createDataListFromFile();
        List<DifferenceInterface> daysWithSmallestTempSpreadList = this.algorithms.getMinimumDifference(weatherDayDataList);

        return formatResultStringWeather(daysWithSmallestTempSpreadList);
    }

    private String calculateSmallestGoalSpread(String fileName) throws IOException {
        CSVReader csvReaderFootball = new CSVReaderFootball(fileName);
        List<DifferenceInterface> footballDataList = csvReaderFootball.createDataListFromFile();
        List<DifferenceInterface> teamsWithSmallestGoalSpreadList = this.algorithms.getMinimumDifference(footballDataList);

        return formatResultStringFootball(teamsWithSmallestGoalSpreadList);
    }

    private String formatResultStringWeather(List<DifferenceInterface> dataWithSmallestDifferenceList) {
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

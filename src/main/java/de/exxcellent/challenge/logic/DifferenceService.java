package de.exxcellent.challenge.logic;

import de.exxcellent.challenge.data.DifferenceInterface;
import de.exxcellent.challenge.reader.CSVReader;
import de.exxcellent.challenge.reader.CSVReaderFootball;
import de.exxcellent.challenge.reader.CSVReaderWeather;

import java.io.IOException;
import java.util.List;

public class DifferenceService {

    private Algorithms algorithms;
    private String footballContext = "--football";
    private String weatherContext = "--weather";

    public DifferenceService() {
        algorithms = new Algorithms();
    }

    public String calculateSmallestDifference(String context, String fileName) throws IOException {
        String result;

        if ( isFootballContext(context) ) {
            result = calculateSmallestGoalSpread(fileName);
        }
        else if ( isWeatherContext(context) ) {
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
        List<DifferenceInterface> daysWithSmallestTempSpreadList = this.algorithms.getSmallestDifference(weatherDayDataList);

        return formatResultStringWeather(daysWithSmallestTempSpreadList);
    }

    private String calculateSmallestGoalSpread(String fileName) throws IOException {
        CSVReader csvReaderFootball = new CSVReaderFootball(fileName);
        List<DifferenceInterface> footballDataList = csvReaderFootball.createDataListFromFile();
        List<DifferenceInterface> teamsWithSmallestGoalSpreadList = this.algorithms.getSmallestDifference(footballDataList);

        return formatResultStringFootball(teamsWithSmallestGoalSpreadList);
    }

    private boolean isWeatherContext(String context) {
        return context.equalsIgnoreCase(this.weatherContext);
    }

    private boolean isFootballContext(String context) {
        return context.equalsIgnoreCase(this.footballContext);
    }

    private String formatResultStringWeather(List<DifferenceInterface> dataWithSmallestDifferenceList) {
        StringBuilder resultString = new StringBuilder("Day(s) with smallest temperature spread :");

        addAllDataWithSmallestDifferenceToResultString(dataWithSmallestDifferenceList, resultString);

        return resultString.toString();
    }

    private String formatResultStringFootball(List<DifferenceInterface> dataWithSmallestDifferenceList) {
        StringBuilder resultString = new StringBuilder("Team(s) with smallest goal spread :");

        addAllDataWithSmallestDifferenceToResultString(dataWithSmallestDifferenceList, resultString);

        return resultString.toString();
    }

    private void addAllDataWithSmallestDifferenceToResultString(List<DifferenceInterface> dataWithSmallestDifferenceList, StringBuilder resultString) {
        for ( DifferenceInterface dataWithSmallestDifference: dataWithSmallestDifferenceList) {
            resultString.append(" ").append(dataWithSmallestDifference);
        }
    }
}

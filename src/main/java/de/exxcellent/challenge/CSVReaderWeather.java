package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderWeather {
    private String fileName;
    private final String delimiter = ",";
    private final int columnNumberDay = 0;
    private final int columnNumberMaximumTemperature = 1;
    private final int columnNumberMinimumTemperature = 2;

    public CSVReaderWeather(String fileName) {
        this.fileName = fileName;
    }

    public List<WeatherDayData> createWeatherDataDayListFromFile() throws IOException {
        List<WeatherDayData> weatherDayDataList = new ArrayList<>();

        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));

        skipHeaderLine(bufferedReader);

        while ( (line = bufferedReader.readLine() ) != null ) {
            weatherDayDataList.add(createWeatherDayDataFromLine(line));
        }

        return weatherDayDataList;
    }

    private void skipHeaderLine(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
    }

    private WeatherDayData createWeatherDayDataFromLine(String line) {
        String[] values = line.split(this.delimiter);

        int day = Integer.parseInt(values[this.columnNumberDay]);
        int maximumTemperature = Integer.parseInt(values[this.columnNumberMaximumTemperature]);
        int minimumTemperature = Integer.parseInt(values[this.columnNumberMinimumTemperature]);

        return new WeatherDayData(day, maximumTemperature, minimumTemperature);
    }
}

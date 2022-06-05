package de.exxcellent.challenge;


public class CSVReaderWeather extends CSVReader {

    private final int columnNumberDay = 0;
    private final int columnNumberMaximumTemperature = 1;
    private final int columnNumberMinimumTemperature = 2;

    public CSVReaderWeather(String fileName) {
        super(fileName);
    }


    protected DifferenceInterface createDataObjectFromLine(String line) {
        String[] values = line.split(this.delimiter);

        int day = Integer.parseInt(values[this.columnNumberDay]);
        int maximumTemperature = Integer.parseInt(values[this.columnNumberMaximumTemperature]);
        int minimumTemperature = Integer.parseInt(values[this.columnNumberMinimumTemperature]);

        return new WeatherDayData(day, maximumTemperature, minimumTemperature);
    }
}

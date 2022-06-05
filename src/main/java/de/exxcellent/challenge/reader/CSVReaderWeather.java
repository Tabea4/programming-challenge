package de.exxcellent.challenge.reader;


import de.exxcellent.challenge.data.DifferenceInterface;
import de.exxcellent.challenge.data.WeatherDayData;

import java.io.IOException;

public class CSVReaderWeather extends CSVReader {

    private final int columnNumberDay = 0;
    private final int columnNumberMaximumTemperature = 1;
    private final int columnNumberMinimumTemperature = 2;

    public CSVReaderWeather(String fileName) {
        super(fileName);
    }


    protected DifferenceInterface createDataObjectFromLine(String line) throws IOException {
        String[] row_entries = line.split(this.delimiter);

        if ( rowHasEnoughData( row_entries.length ) ) {
            int day = Integer.parseInt(row_entries[this.columnNumberDay]);
            int maximumTemperature = Integer.parseInt(row_entries[this.columnNumberMaximumTemperature]);
            int minimumTemperature = Integer.parseInt(row_entries[this.columnNumberMinimumTemperature]);

            return new WeatherDayData(day, maximumTemperature, minimumTemperature);
        }
        else {
            throw new IOException("Column not containing maxmimum/minimum value.");
        }
    }

    private boolean rowHasEnoughData(int lengthOfLine) {
        return lengthOfLine > getMaximumIndexOfAllNeededColumns();
    }

    private int getMaximumIndexOfAllNeededColumns() {
        return Math.max(Math.max(this.columnNumberDay, this.columnNumberMinimumTemperature), this.columnNumberMaximumTemperature);
    }
}

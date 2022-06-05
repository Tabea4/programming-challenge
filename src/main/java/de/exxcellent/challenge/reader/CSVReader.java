package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.data.DifferenceInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class CSVReader {

    private String fileName;
    protected final String delimiter = ",";


    public CSVReader(String fileName) {
        this.fileName = fileName;
    }

    public List<DifferenceInterface> createDataListFromFile() throws IOException {
        List<DifferenceInterface> weatherDayDataList = new ArrayList<>();

        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));

        skipHeaderLine(bufferedReader);

        while ( (line = bufferedReader.readLine() ) != null ) {
            weatherDayDataList.add(createDataObjectFromLine(line));
        }

        return weatherDayDataList;
    }

    private void skipHeaderLine(BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();
        ifFileIsEmptyThrowException(line);
    }

    private void ifFileIsEmptyThrowException(String line) throws IOException {
        if ( line == null ) {
            throw new IOException("File is empty.");
        }
    }

    protected abstract DifferenceInterface createDataObjectFromLine(String line) throws IOException;

}

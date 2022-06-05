package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.data.DifferenceInterface;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVReaderFootballTest {

    private final String testFileNameFootballData = "src/test/resources/de/exxcellent/challenge/football.csv";
    private final String emptyFile = "src/test/resources/de/exxcellent/challenge/empty_file.csv";
    private final String fileNotContainMaximumAndMinimumValue = "src/test/resources/de/exxcellent/challenge/broken_file.csv";
    private final int footballDataSize = 20;

    @Test
    void whenReadingTestFileReturns20FootballData() throws IOException {
        // Given
        CSVReader csvReaderFootball = new CSVReaderFootball(this.testFileNameFootballData);

        // When
        List<DifferenceInterface> footballDataList = csvReaderFootball.createDataListFromFile();

        // Then
        assertEquals(this.footballDataSize, footballDataList.size());
    }

    @Test
    void whenFileIsEmptyThrowsIOException() {
        // Given
        CSVReader csvReaderFootball = new CSVReaderFootball(this.emptyFile);

        // When, then
        Throwable exceptionThatWasThrown = assertThrows(IOException.class, () -> {
            csvReaderFootball.createDataListFromFile();
        });
        assertEquals(exceptionThatWasThrown.getMessage(), "File is empty.");
    }

    @Test
    void whenFileNotContainsMinimumAndMaximumValueThrowsIOException() {
        // Given
        CSVReader csvReaderFootball = new CSVReaderFootball(this.fileNotContainMaximumAndMinimumValue);

        // When, then
        Throwable exceptionThatWasThrown = assertThrows(IOException.class, () -> {
            csvReaderFootball.createDataListFromFile();
        });
        assertEquals(exceptionThatWasThrown.getMessage(), "Column not containing maximum/minimum value.");
    }

}

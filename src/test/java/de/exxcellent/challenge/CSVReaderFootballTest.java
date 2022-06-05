package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVReaderFootballTest {

    private final String testFileNameFootballData = "src/test/resources/de/exxcellent/challenge/football.csv";
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

}

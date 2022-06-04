package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferenceServiceAcceptanceTest {
    private final String testFileNameWeatherData = "src/test/resources/de/exxcellent/challenge/weather.csv";

    @Test
    void whenCalculatingSmallestTempSpreadForTestDataShouldReturnCorrectString() throws IOException {
        // Given
        DifferenceService differenceService = new DifferenceService();

        // When
        String dayWithSmallestTempSpread = differenceService.calculateSmallestTempSpread(this.testFileNameWeatherData);

        // Then
        assertEquals(dayWithSmallestTempSpread, "Day(s) with smallest temperature spread : 14");
    }

}

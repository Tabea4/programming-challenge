package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferenceServiceAcceptanceTest {
    private final String testFileNameWeatherData = "src/test/resources/de/exxcellent/challenge/weather.csv";
    private final String testFileNameFootbalData = "src/test/resources/de/exxcellent/challenge/football.csv";

    @Test
    void whenCalculatingSmallestTempSpreadForTestDataShouldReturnCorrectString() throws IOException {
        // Given
        DifferenceService differenceService = new DifferenceService();

        // When
        String dayWithSmallestTempSpread = differenceService.calculateSmallestTempSpread(this.testFileNameWeatherData);

        // Then
        assertEquals("Day(s) with smallest temperature spread : 14", dayWithSmallestTempSpread);
    }

    @Test
    void whenCalculatingTeamWithSmallestGoalSpreadForTestDataShouldReturnCorrectString() throws IOException {
        // Given
        DifferenceService differenceService = new DifferenceService();

        // When
        String teamWithSmallestGoalSpread = differenceService.calculateSmallestGoalSpread(this.testFileNameFootbalData);

        // Then
        assertEquals("Team(s) with smallest goal spread : Aston_Villa", teamWithSmallestGoalSpread);
    }

}

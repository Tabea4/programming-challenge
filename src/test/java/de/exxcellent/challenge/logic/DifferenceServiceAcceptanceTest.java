package de.exxcellent.challenge.logic;

import de.exxcellent.challenge.logic.DifferenceService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DifferenceServiceAcceptanceTest {
    private final String testFileNameWeatherData = "src/test/resources/de/exxcellent/challenge/weather.csv";
    private final String testFileNameFootbalData = "src/test/resources/de/exxcellent/challenge/football.csv";
    private final String footballContext = "--football";
    private final String weatherContext = "--weather";
    private final String wrongContext = "wrongContext";

    @Test
    void whenCalculatingSmallestTempSpreadForTestDataShouldReturnCorrectString() throws IOException {
        // Given
        DifferenceService differenceService = new DifferenceService();

        // When
        String dayWithSmallestTempSpread = differenceService.calculateSmallestDifference(this.weatherContext, this.testFileNameWeatherData);

        // Then
        assertEquals("Day(s) with smallest temperature spread : 14", dayWithSmallestTempSpread);
    }

    @Test
    void whenCalculatingTeamWithSmallestGoalSpreadForTestDataShouldReturnCorrectString() throws IOException {
        // Given
        DifferenceService differenceService = new DifferenceService();

        // When
        String teamWithSmallestGoalSpread = differenceService.calculateSmallestDifference(this.footballContext, this.testFileNameFootbalData);

        // Then
        assertEquals("Team(s) with smallest goal spread : Aston_Villa", teamWithSmallestGoalSpread);
    }

    @Test
    void whenGivingWrongContextThrowsIllegalArgumentException() throws IllegalArgumentException {
        // Given
        DifferenceService differenceService = new DifferenceService();

        // When, then
        assertThrows(IllegalArgumentException.class, () -> {
            differenceService.calculateSmallestDifference(this.wrongContext, this.testFileNameFootbalData);
        });
    }

}

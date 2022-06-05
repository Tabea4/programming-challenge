package de.exxcellent.challenge.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DifferenceServiceAcceptanceTest {
    private final String testFileNameWeatherData = "src/test/resources/de/exxcellent/challenge/weather.csv";
    private final String testFileNameFootballData = "src/test/resources/de/exxcellent/challenge/football.csv";
    private final String footballContext = "--football";
    private final String weatherContext = "--weather";
    private final String wrongContext = "wrongContext";

    private DifferenceService differenceService;

    @BeforeEach
    void setUp() {
        this.differenceService = new DifferenceService();
    }

    @Test
    void whenCalculatingSmallestTempSpreadForTestDataShouldReturnCorrectString() throws IOException {
        // When
        String dayWithSmallestTempSpread = this.differenceService.calculateSmallestDifference(this.weatherContext, this.testFileNameWeatherData);

        // Then
        assertEquals("Day(s) with smallest temperature spread : 14", dayWithSmallestTempSpread);
    }

    @Test
    void whenCalculatingTeamWithSmallestGoalSpreadForTestDataShouldReturnCorrectString() throws IOException {
        // When
        String teamWithSmallestGoalSpread = this.differenceService.calculateSmallestDifference(this.footballContext, this.testFileNameFootballData);

        // Then
        assertEquals("Team(s) with smallest goal spread : Aston_Villa", teamWithSmallestGoalSpread);
    }

    @Test
    void whenGivingWrongContextThrowsIllegalArgumentException() throws IllegalArgumentException {
        // When, then
        assertThrows(IllegalArgumentException.class, () -> {
            this.differenceService.calculateSmallestDifference(this.wrongContext, this.testFileNameFootballData);
        });
    }

}

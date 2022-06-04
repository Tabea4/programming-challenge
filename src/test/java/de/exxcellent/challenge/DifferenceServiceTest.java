package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferenceServiceTest {
    @Test
    void whenContextIsWeatherShouldReturnWeatherString() {
        // Given
        DifferenceService differenceService = new DifferenceService();

        // When
        String dayWithSmallestTempSpread = differenceService.getMaximumDifference("--weather", "weather.csv");

        // Then
        assertEquals(dayWithSmallestTempSpread, "Day with smallest temperature spread : 0");
    }

}

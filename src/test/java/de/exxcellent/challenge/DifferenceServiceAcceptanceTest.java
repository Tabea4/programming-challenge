package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferenceServiceAcceptanceTest {
    @Test
    void whenCalculatingSmallestTempSpreadForTestDataShouldReturnCorrectString() {
        // Given
        DifferenceService differenceService = new DifferenceService();

        // When
        String dayWithSmallestTempSpread = differenceService.calculateSmallestTempSpread("weather.csv");

        // Then
        assertEquals(dayWithSmallestTempSpread, "Day with smallest temperature spread : 9");
    }

}

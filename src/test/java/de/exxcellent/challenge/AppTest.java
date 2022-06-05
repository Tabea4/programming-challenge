package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {
    private final String testFileNameWeatherData = "src/test/resources/de/exxcellent/challenge/weather.csv";
    private final String testFileNameFootbalData = "src/test/resources/de/exxcellent/challenge/football.csv";
    private final String footballContext = "--football";
    private final String weatherContext = "--weather";

    @Test
    void runFootball() throws IOException {
        App.main(this.footballContext, this.testFileNameFootbalData);
    }

    @Test
    void runWeather() throws IOException {
        App.main(this.weatherContext, this.testFileNameWeatherData);
    }

    @Test
    void whenLessThanTwoArgumentsArePassedThrowIllegalArgumentException() {
        // Given, when, then
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class, () -> {
            App.main();
        });
        assertEquals(exceptionThatWasThrown.getMessage(), "Must pass at least two arguments: context and fileName");
    }

}
package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AppTest {
    private final String testFileNameWeatherData = "src/test/resources/de/exxcellent/challenge/weather.csv";
    private final String testFileNameFootballData = "src/test/resources/de/exxcellent/challenge/football.csv";
    private final String emptyFileName = "src/test/resources/de/exxcellent/challenge/empty_file.csv";
    private final String footballContext = "--football";
    private final String weatherContext = "--weather";

    @Test
    void runFootball() {
        App.main(this.footballContext, this.testFileNameFootballData);
    }

    @Test
    void runWeather() {
        App.main(this.weatherContext, this.testFileNameWeatherData);
    }

    @Test
    void whenLessThanTwoArgumentsArePassedPrintMessageToConsole() {
        // Given
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        // When
        App.main();

        // Then
        assertEquals("Must pass at least two arguments: context and fileName\n", errContent.toString());
    }

    @Test
    void whenEmptyFileIsPassedPrintIOExceptionMessageToConsole() {
        // Given
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        // When
        App.main(this.footballContext, this.emptyFileName);

        // Then
        assertEquals("File is empty.\n", errContent.toString());
    }

}
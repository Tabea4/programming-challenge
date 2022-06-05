package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVReaderWeatherTest {

    private final String testFileNameWeatherData = "src/test/resources/de/exxcellent/challenge/weather.csv";
    private final String nonExistingFile = "someRandomFileNameThatDoesNotExist";
    private final String wrongFormattedFile = "src/test/resources/de/exxcellent/challenge/weather_max_temp_not_int.csv";
    private final int weatherDataSize = 30;


    @Test
    void whenReadingTestFileReturns30WeatherDayData() throws IOException {
        // Given
        CSVReaderWeather csvReaderWeather = new CSVReaderWeather(this.testFileNameWeatherData);

        // When
        List<WeatherDayData> weatherDayDataList = csvReaderWeather.createWeatherDataDayListFromFile();

        // Then
        assertEquals(this.weatherDataSize, weatherDayDataList.size());
    }

    @Test
    void whenFileDoesNotExistsThrowsIOException() {
        // Given
        CSVReaderWeather csvReaderWeather = new CSVReaderWeather(this.nonExistingFile);

        // When, then
        assertThrows(IOException.class, () -> {
            csvReaderWeather.createWeatherDataDayListFromFile();
        });
    }

    @Test
    void whenMaximumTemperatureIsNotIntegerThrowsNumberFormatException() {
        // Given
        CSVReaderWeather csvReaderWeather = new CSVReaderWeather(this.wrongFormattedFile);

        // When, then
        assertThrows(NumberFormatException.class, () -> {
            csvReaderWeather.createWeatherDataDayListFromFile();
        });
    }
}

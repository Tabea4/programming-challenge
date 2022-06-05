package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.data.DifferenceInterface;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVReaderWeatherTest {

    private final String testFileNameWeatherData = "src/test/resources/de/exxcellent/challenge/weather.csv";
    private final String nonExistingFile = "someRandomFileNameThatDoesNotExist";
    private final String wrongFormattedFile = "src/test/resources/de/exxcellent/challenge/weather_max_temp_not_int.csv";
    private final String fileNotContainMaximumAndMinimumValue = "src/test/resources/de/exxcellent/challenge/broken_weather_file.csv";
    private final int weatherDataSize = 30;


    @Test
    void whenReadingTestFileReturns30WeatherDayData() throws IOException {
        // Given
        CSVReader csvReaderWeather = new CSVReaderWeather(this.testFileNameWeatherData);

        // When
        List<DifferenceInterface> weatherDayDataList = csvReaderWeather.createDataListFromFile();

        // Then
        assertEquals(this.weatherDataSize, weatherDayDataList.size());
    }

    @Test
    void whenFileDoesNotExistsThrowsIOException() {
        // Given
        CSVReader csvReaderWeather = new CSVReaderWeather(this.nonExistingFile);

        // When, then
        assertThrows(IOException.class, () -> {
            csvReaderWeather.createDataListFromFile();
        });
    }

    @Test
    void whenMaximumTemperatureIsNotIntegerThrowsNumberFormatException() {
        // Given
        CSVReader csvReaderWeather = new CSVReaderWeather(this.wrongFormattedFile);

        // When, then
        assertThrows(NumberFormatException.class, () -> {
            csvReaderWeather.createDataListFromFile();
        });
    }

    @Test
    void whenFileNotContainsMinimumAndMaximumValueThrowsIOException() {
        // Given
        CSVReader csvReaderWeather = new CSVReaderWeather(this.fileNotContainMaximumAndMinimumValue);

        // When, then
        Throwable exceptionThatWasThrown = assertThrows(IOException.class, () -> {
            csvReaderWeather.createDataListFromFile();
        });
        assertEquals(exceptionThatWasThrown.getMessage(), "Column not containing maximum/minimum value.");
    }
}

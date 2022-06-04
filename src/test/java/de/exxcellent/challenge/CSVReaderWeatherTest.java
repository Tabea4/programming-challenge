package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVReaderWeatherTest {

    private final String testFileNameWeatherData = "src/test/resources/de/exxcellent/challenge/weather.csv";
    private final int weatherDataSize = 30;

    @Test
    void whenReadingTestFileReturns30WeatherDayData() throws IOException {
        // Given
        CSVReaderWeather csvReaderWeather = new CSVReaderWeather(testFileNameWeatherData);

        // When
        List<WeatherDayData> weatherDayDataList = csvReaderWeather.createWeatherDataDayListFromFile();

        // Then
        assertEquals(weatherDayDataList.size(), weatherDataSize);
    }
}

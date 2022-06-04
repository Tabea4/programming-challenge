package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsTest {

    @Test
    void whenListOfTestWeatherDayDataIsPassedShouldReturnWeatherDayDataWithMaximumDifference() {
        // Given
        Algorithms algorithms = new Algorithms();
        List<WeatherDayData> weatherDayDataList = new ArrayList<>();
        WeatherDayData weatherDayData1 = new WeatherDayData(1, 20, 10);
        WeatherDayData weatherDayData2 = new WeatherDayData(2, 30, 10);
        weatherDayDataList.add(weatherDayData1);
        weatherDayDataList.add(weatherDayData2);

        // When
        List<WeatherDayData> weatherDayDataMaximumDifference = algorithms.getMaximumDifference(weatherDayDataList);

        // Then
        assertEquals(weatherDayDataMaximumDifference.get(0), weatherDayData2);
    }
}

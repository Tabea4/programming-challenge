package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsTest {

    @Test
    void whenListOfTestWeatherDayDataIsPassedShouldReturnOneWeatherDayDataWithMaximumDifference() {
        // Given
        Algorithms algorithms = new Algorithms();
        List<WeatherDayData> weatherDayDataList = new ArrayList<>();
        WeatherDayData weatherDayData1 = new WeatherDayData(1, 20, 10);
        WeatherDayData weatherDayData2 = new WeatherDayData(2, 30, 10);
        weatherDayDataList.add(weatherDayData1);
        weatherDayDataList.add(weatherDayData2);

        // When
        List<WeatherDayData> weatherDayDataMaximumDifferenceList = algorithms.getMaximumDifference(weatherDayDataList);

        // Then
        assertEquals(weatherDayDataMaximumDifferenceList.get(0), weatherDayData2);
    }

    @Test
    void whenListOfTestWeatherDayDataIsPassedShouldReturnTwoWeatherDayDataWithMaximumDifference() {
        // Given
        Algorithms algorithms = new Algorithms();
        List<WeatherDayData> weatherDayDataList = new ArrayList<>();
        WeatherDayData weatherDayData1 = new WeatherDayData(1, 20, 10);
        WeatherDayData weatherDayData2 = new WeatherDayData(2, 20, 10);
        weatherDayDataList.add(weatherDayData1);
        weatherDayDataList.add(weatherDayData2);

        // When
        List<WeatherDayData> weatherDayDataMaximumDifferenceList = algorithms.getMaximumDifference(weatherDayDataList);

        // Then
        assertEquals(weatherDayDataList, weatherDayDataMaximumDifferenceList);
    }

    @Test
    void whenListOfTestWeatherDayDataIsEmptyShouldReturnEmptyList() {
        // Given
        Algorithms algorithms = new Algorithms();
        List<WeatherDayData> weatherDayDataList = new ArrayList<>();

        // When
        List<WeatherDayData> weatherDayDataMaximumDifferenceList = algorithms.getMaximumDifference(weatherDayDataList);

        // Then
        assertEquals(0, weatherDayDataMaximumDifferenceList.size());
    }
}

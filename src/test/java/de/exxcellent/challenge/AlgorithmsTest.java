package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsTest {

    @Test
    void whenListOfTestWeatherDayDataIsPassedShouldReturnOneWeatherDayDataWithMinimumDifference() {
        // Given
        Algorithms algorithms = new Algorithms();
        List<WeatherDayData> weatherDayDataList = new ArrayList<>();
        WeatherDayData weatherDayData1 = new WeatherDayData(1, 20, 10);
        WeatherDayData weatherDayData2 = new WeatherDayData(2, 30, 10);
        weatherDayDataList.add(weatherDayData1);
        weatherDayDataList.add(weatherDayData2);

        // When
        List<WeatherDayData> weatherDayDataMinimumDifferenceList = algorithms.getMinimumDifference(weatherDayDataList);

        // Then
        assertEquals(weatherDayDataMinimumDifferenceList.get(0), weatherDayData1);
    }

    @Test
    void whenListOfTestWeatherDayDataIsPassedShouldReturnTwoWeatherDayDataWithMinimumDifference() {
        // Given
        Algorithms algorithms = new Algorithms();
        List<WeatherDayData> weatherDayDataList = new ArrayList<>();
        WeatherDayData weatherDayData1 = new WeatherDayData(1, 20, 10);
        WeatherDayData weatherDayData2 = new WeatherDayData(2, 20, 10);
        weatherDayDataList.add(weatherDayData1);
        weatherDayDataList.add(weatherDayData2);

        // When
        List<WeatherDayData> weatherDayDataMinimumDifferenceList = algorithms.getMinimumDifference(weatherDayDataList);

        // Then
        assertEquals(weatherDayDataList, weatherDayDataMinimumDifferenceList);
    }

    @Test
    void whenListOfTestWeatherDayDataIsEmptyShouldReturnEmptyList() {
        // Given
        Algorithms algorithms = new Algorithms();
        List<WeatherDayData> weatherDayDataList = new ArrayList<>();

        // When
        List<WeatherDayData> weatherDayDataMinimumDifferenceList = algorithms.getMinimumDifference(weatherDayDataList);

        // Then
        assertEquals(0, weatherDayDataMinimumDifferenceList.size());
    }
}

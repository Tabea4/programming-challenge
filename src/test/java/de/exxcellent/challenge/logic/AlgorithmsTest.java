package de.exxcellent.challenge.logic;

import de.exxcellent.challenge.data.DifferenceInterface;
import de.exxcellent.challenge.data.FootballData;
import de.exxcellent.challenge.data.WeatherDayData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsTest {

    private Algorithms algorithms;

    @BeforeEach
    void setUp() {
        this.algorithms = new Algorithms();
    }

    @Test
    void whenListOfTestWeatherDayDataIsPassedShouldReturnOneWeatherDayDataWithMinimumDifference() {
        // Given
        List<DifferenceInterface> weatherDayDataList = new ArrayList<>();
        DifferenceInterface weatherDayData1 = new WeatherDayData(1, 20, 10);
        DifferenceInterface weatherDayData2 = new WeatherDayData(2, 30, 10);
        weatherDayDataList.add(weatherDayData1);
        weatherDayDataList.add(weatherDayData2);

        // When
        List<DifferenceInterface> weatherDayDataMinimumDifferenceList = this.algorithms.calculateSmallestDifference(weatherDayDataList);

        // Then
        assertEquals(weatherDayDataMinimumDifferenceList.get(0), weatherDayData1);
    }

    @Test
    void whenListOfTestWeatherDayDataIsPassedShouldReturnTwoWeatherDayDataWithMinimumDifference() {
        // Given
        List<DifferenceInterface> weatherDayDataList = new ArrayList<>();
        DifferenceInterface weatherDayData1 = new WeatherDayData(1, 20, 10);
        DifferenceInterface weatherDayData2 = new WeatherDayData(2, 20, 10);
        weatherDayDataList.add(weatherDayData1);
        weatherDayDataList.add(weatherDayData2);

        // When
        List<DifferenceInterface> weatherDayDataMinimumDifferenceList = this.algorithms.calculateSmallestDifference(weatherDayDataList);

        // Then
        assertEquals(weatherDayDataList, weatherDayDataMinimumDifferenceList);
    }

    @Test
    void whenListOfTestWeatherDayDataIsEmptyShouldReturnEmptyList() {
        // Given
        List<DifferenceInterface> weatherDayDataList = new ArrayList<>();

        // When
        List<DifferenceInterface> weatherDayDataMinimumDifferenceList = this.algorithms.calculateSmallestDifference(weatherDayDataList);

        // Then
        assertEquals(0, weatherDayDataMinimumDifferenceList.size());
    }

    @Test
    void whenListOfTestFootballDataIsPassedShouldReturnOneFootballDataWithMinimumDifference() {
        // Given
        List<DifferenceInterface> footballDataList = new ArrayList<>();
        DifferenceInterface footballData1 = new FootballData("FV Mönchengladbach", 95, 16);
        DifferenceInterface footballData2 = new FootballData("Borussia Mönchengladbach", 88, 17);
        footballDataList.add(footballData1);
        footballDataList.add(footballData2);

        // When
        List<DifferenceInterface> footballDataMinimumDifferenceList = this.algorithms.calculateSmallestDifference(footballDataList);

        // Then
        assertEquals(footballDataMinimumDifferenceList.get(0), footballData2);
    }

    @Test
    void whenListOfTestFootballDataIsPassedShouldReturnTwoFootballDataWithMinimumDifference() {
        // Given
        List<DifferenceInterface> footballDataList = new ArrayList<>();
        DifferenceInterface footballData1 = new FootballData("CfR Links", 80, 70);
        DifferenceInterface footballData2 = new FootballData("Borussia Bocholt", 40, 30);
        footballDataList.add(footballData1);
        footballDataList.add(footballData2);

        // When
        List<DifferenceInterface> footballDataMinimumDifferenceList = this.algorithms.calculateSmallestDifference(footballDataList);

        // Then
        assertEquals(footballDataList, footballDataMinimumDifferenceList);
    }

    @Test
    void whenListOfTestFootballDataIsEmptyShouldReturnEmptyList() {
        // Given
        List<DifferenceInterface> footballDataList = new ArrayList<>();

        // When
        List<DifferenceInterface> footballDataMinimumDifferenceList = this.algorithms.calculateSmallestDifference(footballDataList);

        // Then
        assertEquals(0, footballDataMinimumDifferenceList.size());
    }
}

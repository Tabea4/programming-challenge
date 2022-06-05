package de.exxcellent.challenge.logic;

import de.exxcellent.challenge.data.DifferenceInterface;

import java.util.Comparator;

public class CompareByDifference implements Comparator<DifferenceInterface> {
    @Override
    public int compare(DifferenceInterface differenceData1, DifferenceInterface differenceData2) {
        int differenceTemperatureWeatherDayData1 = Math.abs(differenceData1.getFirstValue() - differenceData1.getSecondValue());
        int differenceTemperatureWeatherDayData2 = Math.abs(differenceData2.getFirstValue() - differenceData2.getSecondValue());

        return Integer.compare(differenceTemperatureWeatherDayData1, differenceTemperatureWeatherDayData2);
    }
}

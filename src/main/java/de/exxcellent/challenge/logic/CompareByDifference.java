package de.exxcellent.challenge.logic;

import de.exxcellent.challenge.data.DifferenceInterface;

public class CompareByDifference implements java.util.Comparator<DifferenceInterface> {
    @Override
    public int compare(DifferenceInterface differenceData1, DifferenceInterface differenceData2) {
        int differenceTemperatureWeatherDayData1 = Math.abs(differenceData1.getMaximumValue() - differenceData1.getMinimumValue());
        int differenceTemperatureWeatherDayData2 = Math.abs(differenceData2.getMaximumValue() - differenceData2.getMinimumValue());

        return Integer.compare(differenceTemperatureWeatherDayData1, differenceTemperatureWeatherDayData2);
    }
}

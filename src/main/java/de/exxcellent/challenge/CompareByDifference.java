package de.exxcellent.challenge;

public class CompareByDifference implements java.util.Comparator<DifferenceInterface> {
    @Override
    public int compare(DifferenceInterface differenceData1, DifferenceInterface differenceData2) {
        int differenceTemperatureWeatherDayData1 = differenceData1.getMaximumValue() - differenceData1.getMinimumValue();
        int differenceTemperatureWeatherDayData2 = differenceData2.getMaximumValue() - differenceData2.getMinimumValue();

        return Integer.compare(differenceTemperatureWeatherDayData1, differenceTemperatureWeatherDayData2);
    }
}

package de.exxcellent.challenge.logic;

import de.exxcellent.challenge.data.DifferenceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithms {

    private CompareByDifference compareByDifference;

    public Algorithms() {
       this.compareByDifference = new CompareByDifference();
    }
    public List<DifferenceInterface> getMinimumDifference(List<DifferenceInterface> differenceDataList) {
        if (differenceDataList.isEmpty()) {
            return new ArrayList<>();
        }
        else {
            return getWeatherDayDataMinimumDifference(differenceDataList);
        }
    }

    private List<DifferenceInterface> getWeatherDayDataMinimumDifference(List<DifferenceInterface> differenceDataList) {
        differenceDataList.sort(this.compareByDifference);

        DifferenceInterface oneDifferenceDataObjectWithMinimumDifference = getOneElementWithSmallestDifference(differenceDataList);

        return filterForAllElementsWithMinimumDifference(differenceDataList, oneDifferenceDataObjectWithMinimumDifference);
    }

    private DifferenceInterface getOneElementWithSmallestDifference(List<DifferenceInterface> differenceDataList) {
        return differenceDataList.get(0);
    }

    private List<DifferenceInterface> filterForAllElementsWithMinimumDifference(List<DifferenceInterface> differenceDataList, DifferenceInterface oneDifferenceDataObjectWithMinimumDifference) {
        return differenceDataList.stream()
                                 .filter( differenceData -> this.compareByDifference.compare(differenceData, oneDifferenceDataObjectWithMinimumDifference) == 0)
                                 .collect(Collectors.toList());
    }

    public List<DifferenceInterface> getMinimumDifferenceFootball(List<DifferenceInterface> differenceDataList) {
        return null;
    }
}

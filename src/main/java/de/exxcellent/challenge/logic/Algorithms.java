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

    public List<DifferenceInterface> getSmallestDifference(List<DifferenceInterface> differenceDataList) {
        if (differenceDataList.isEmpty()) {
            return new ArrayList<>();
        }
        else {
            return filterForAllElementsWithSmallestDifference(differenceDataList);
        }
    }

    private List<DifferenceInterface> filterForAllElementsWithSmallestDifference(List<DifferenceInterface> differenceDataList) {
        differenceDataList.sort(this.compareByDifference);

        DifferenceInterface oneDifferenceDataObjectWithSmallestDifference = getOneElementWithSmallestDifference(differenceDataList);

        return differenceDataList.stream()
                                 .filter( differenceData -> this.compareByDifference.compare(differenceData, oneDifferenceDataObjectWithSmallestDifference) == 0)
                                 .collect(Collectors.toList());
    }

    private DifferenceInterface getOneElementWithSmallestDifference(List<DifferenceInterface> differenceDataList) {
        return differenceDataList.get(0);
    }
}

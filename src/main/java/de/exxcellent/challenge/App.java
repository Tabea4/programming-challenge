package de.exxcellent.challenge;

import de.exxcellent.challenge.logic.DifferenceService;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws IOException {

        // Your preparation code …
        DifferenceService differenceService = new DifferenceService();
        String resultSmallestDifference = differenceService.calculateSmallestTempSpread(args[0]);     // Your day analysis function call …
        System.out.println(resultSmallestDifference);
    }
}

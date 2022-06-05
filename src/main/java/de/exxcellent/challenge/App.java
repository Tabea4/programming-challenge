package de.exxcellent.challenge;

import de.exxcellent.challenge.logic.DifferenceService;

import java.io.IOException;


public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws IOException {

        if ( args.length >= 2 ) {
            DifferenceService differenceService = new DifferenceService();
            String resultSmallestDifference = differenceService.calculateSmallestDifference(args[0], args[1]);
            System.out.println(resultSmallestDifference);
        }
        else {
            throw new IllegalArgumentException("Must pass at least two arguments: context and fileName");
        }
    }
}

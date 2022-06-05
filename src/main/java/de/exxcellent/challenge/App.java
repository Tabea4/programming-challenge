package de.exxcellent.challenge;

import de.exxcellent.challenge.logic.DifferenceService;

import java.io.IOException;


public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args)  {

        if ( args.length >= 2 ) {
            try {
                DifferenceService differenceService = new DifferenceService();
                String resultSmallestDifference = differenceService.calculateSmallestDifference(args[0], args[1]);
                System.out.println(resultSmallestDifference);
            }
            catch (IOException exception) {
                System.err.println(exception.getMessage());
            }
        }
        else {
            System.err.println("Must pass at least two arguments: context and fileName");
        }
    }
}

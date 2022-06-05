package de.exxcellent.challenge;


import java.io.IOException;

public class CSVReaderFootball extends CSVReader {

    private final int columnNumberTeam = 0;
    private final int columnNumberGoals = 5;
    private final int columnNumberGoalsAllowed = 6;

    public CSVReaderFootball(String fileName) {
        super(fileName);
    }

    protected DifferenceInterface createDataObjectFromLine(String line) throws IOException {
        String[] row_entries = line.split(this.delimiter);

        if ( rowHasEnoughData( row_entries.length ) ) {
            String team = row_entries[this.columnNumberTeam];
            int goals = Integer.parseInt(row_entries[this.columnNumberGoals]);
            int goalsAllowed = Integer.parseInt(row_entries[this.columnNumberGoalsAllowed]);

            return new FootballData(team, goals, goalsAllowed);
        }
        else {
            throw new IOException("Column not containing maxmimum/minimum value.");
        }
    }

    private boolean rowHasEnoughData(int lengthOfLine) {
        return lengthOfLine > getMaximumIndexOfAllNeededColumns();
    }

    private int getMaximumIndexOfAllNeededColumns() {
        return Math.max(Math.max(this.columnNumberTeam, this.columnNumberGoals), this.columnNumberGoalsAllowed);
    }
}

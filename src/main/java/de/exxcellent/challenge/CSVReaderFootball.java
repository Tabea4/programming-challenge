package de.exxcellent.challenge;


public class CSVReaderFootball extends CSVReader {

    private final int columnNumberTeam = 0;
    private final int columnNumberGoals = 5;
    private final int columnNumberGoalsAllowed = 6;

    public CSVReaderFootball(String fileName) {
        super(fileName);
    }

    protected DifferenceInterface createDataObjectFromLine(String line) {
        String[] values = line.split(this.delimiter);

        String team = values[this.columnNumberTeam];
        int goals = Integer.parseInt(values[this.columnNumberGoals]);
        int goalsAllowed = Integer.parseInt(values[this.columnNumberGoalsAllowed]);

        return new FootballData(team, goals, goalsAllowed);
    }
}

package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderFootball {
    private String fileName;
    private final String delimiter = ",";

    private final int columnNumberTeam = 0;
    private final int columnNumberGoals = 5;
    private final int columnNumberGoalsAllowed = 6;

    public CSVReaderFootball(String fileName) {
        this.fileName = fileName;
    }

    public List<FootballData> createFootballDataListFromFile() throws IOException {
        List<FootballData> footballDataList = new ArrayList<>();

        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));

        skipHeaderLine(bufferedReader);

        while ( (line = bufferedReader.readLine() ) != null ) {
            footballDataList.add(createFootballDataFromLine(line));
        }

        return footballDataList;
    }

    private void skipHeaderLine(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine();
    }

    private FootballData createFootballDataFromLine(String line) {
        String[] values = line.split(this.delimiter);

        String team = values[this.columnNumberTeam];
        int goals = Integer.parseInt(values[this.columnNumberGoals]);
        int goalsAllowed = Integer.parseInt(values[this.columnNumberGoalsAllowed]);

        return new FootballData(team, goals, goalsAllowed);
    }
}

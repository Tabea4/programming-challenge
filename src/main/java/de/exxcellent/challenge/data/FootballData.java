package de.exxcellent.challenge.data;

public class FootballData implements DifferenceInterface {
    private String team;
    private int goals;
    private int goalsAllowed;

    public FootballData(String team, int goals, int goalsAllowed) {
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }

    @Override
    public int getFirstValue() {
        return this.goals;
    }

    @Override
    public int getSecondValue() {
        return this.goalsAllowed;
    }

    public String toString() {
        return this.team;
    }
}

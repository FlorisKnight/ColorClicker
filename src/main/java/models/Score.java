package models;

public class Score {
    String name;
    int points;
    String gameType;


    public Score(String name, int points, String gameType) {
        this.name = name;
        this.points = points;
        this.gameType = gameType;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getGameType() {
        return gameType;
    }
}

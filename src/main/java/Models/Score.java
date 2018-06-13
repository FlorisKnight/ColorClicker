package Models;

public class Score {
    String name;
    int score;
    String gameType;


    public Score(String name, int score, String gameType) {
        this.name = name;
        this.score = score;
        this.gameType = gameType;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getGameType() {
        return gameType;
    }
}

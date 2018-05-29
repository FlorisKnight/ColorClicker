package WebsocketModels;

public class SaveScore {
    private String username;
    private int score;
    private String gameType;


    public SaveScore(String username, int score, String gameType) {
        this.username = username;
        this.score = score;
        this.gameType = gameType;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public String getGameType() {
        return gameType;
    }

}

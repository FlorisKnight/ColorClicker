package WebsocketModels;

public class JoinGame {
    private int gameID;
    private int userId;

    public JoinGame(int gameID, int userId) {
        this.gameID = gameID;
        this.userId = userId;
    }

    public int getGameID() {
        return gameID;
    }

    public int getUserId() {
        return userId;
    }
}

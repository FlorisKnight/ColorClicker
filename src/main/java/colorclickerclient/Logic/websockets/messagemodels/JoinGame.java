package colorclickerclient.Logic.websockets.messagemodels;

public class JoinGame {
    private int gameID;
    private String userId;

    public JoinGame(int gameID, String userId) {
        this.gameID = gameID;
        this.userId = userId;
    }

    public int getGameID() {
        return gameID;
    }

    public String getUserId() {
        return userId;
    }
}

package WebsocketModels;

public class JoinGame {
    private String gameCode;

    public JoinGame(String gameCode) {
        this.gameCode = gameCode;
    }

    public String getGameCode() {
        return gameCode;
    }

}

package WebsocketModels;

public class CreateGameReceive {
    private String gameCode;
    private String playerName;

    public CreateGameReceive(String gameCode, String playerName){
        this.gameCode = gameCode;
        this.playerName = playerName;
    }

    public String getGameCode() {
        return gameCode;
    }

    public String getPlayerName() {
        return playerName;
    }
}

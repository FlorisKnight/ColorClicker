package ColorClickerWebsocketServer.MessageModels;

public class CreateGameReceive {
    private int gameID;
    private String playerName;

    public CreateGameReceive(int gameID, String playerName){
        this.gameID = gameID;
        this.playerName = playerName;
    }

    public int getGameID() {
        return gameID;
    }

    public String getPlayerName() {
        return playerName;
    }
}

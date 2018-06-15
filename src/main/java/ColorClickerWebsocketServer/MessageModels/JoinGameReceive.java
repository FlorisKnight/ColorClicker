package ColorClickerWebsocketServer.MessageModels;

public class JoinGameReceive {
    private int gameID;
    private String player1Name;
    private String player2Name;

    public JoinGameReceive(int gameID, String player1Name, String player2Name){
        this.gameID = gameID;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public int getGameID() {
        return gameID;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }
}

package WebsocketModels;

public class JoinGameReceive {
    private String gameCode;
    private String player1Name;
    private String player2Name;

    public JoinGameReceive(String gameCode, String player1Name, String player2Name){
        this.gameCode = gameCode;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getGameCode() {
        return gameCode;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }
}

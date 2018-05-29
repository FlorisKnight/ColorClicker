package WebsocketModels;

public class UpdatePlayer {
    private String playerName;

    public UpdatePlayer(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}

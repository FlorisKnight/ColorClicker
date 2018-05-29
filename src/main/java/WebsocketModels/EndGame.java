package WebsocketModels;

public class EndGame {
    public String playerName;

    public EndGame(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName(){
        return playerName;
    }
}

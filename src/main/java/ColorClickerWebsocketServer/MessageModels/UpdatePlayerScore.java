package ColorClickerWebsocketServer.MessageModels;


public class UpdatePlayerScore {
    private int player;
    private int score;

    public UpdatePlayerScore(int player, int score){
        this.player = player;
        this.score = score;
    }

    public int getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }
}

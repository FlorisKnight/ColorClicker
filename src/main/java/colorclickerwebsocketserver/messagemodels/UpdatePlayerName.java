package colorclickerwebsocketserver.messagemodels;


public class UpdatePlayerName {
    String player;

    public UpdatePlayerName(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }
}

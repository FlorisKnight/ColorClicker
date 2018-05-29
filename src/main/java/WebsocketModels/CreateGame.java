package WebsocketModels;

public class CreateGame {
    private int gametype;

    public CreateGame(int gametype) {
        this.gametype = gametype;
    }

    public int getGametype() {
        return gametype;
    }

}

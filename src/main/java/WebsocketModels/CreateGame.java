package WebsocketModels;

public class CreateGame {
    private String gametype;
    private int userId;

    public CreateGame(String gametype, int userId) {
        this.gametype = gametype;
        this.userId = userId;
    }

    public String getGametype() {
        return gametype;
    }

    public int getUserId() {
        return userId;
    }
}

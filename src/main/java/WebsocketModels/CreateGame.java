package WebsocketModels;

public class CreateGame {
    private String gametype;
    private String userId;

    public CreateGame(String gametype, String userId) {
        this.gametype = gametype;
        this.userId = userId;
    }

    public String getGametype() {
        return gametype;
    }

    public String getUserId() {
        return userId;
    }
}

package ColorClickerWebsocketServer.MessageModels;

public class EndGame {
    String name;

    public EndGame(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

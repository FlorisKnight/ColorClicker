package ColorClickerWebsocketServer.REST;

import Models.Score;

public interface IColorClickerWebsocketRESTHandler {
    void setScore(Score score);
    String getPlayerName(String userId);
}

package colorclickerwebsocketserver.restapi;

import models.Score;

public interface IColorClickerWebsocketRESTHandler {
    void setScore(Score score);

    String getPlayerName(String userId);
}

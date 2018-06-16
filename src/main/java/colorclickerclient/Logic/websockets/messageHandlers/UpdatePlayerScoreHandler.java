package colorclickerclient.Logic.websockets.messageHandlers;

import colorclickerclient.Logic.IColorClickerClientGameLogic;
import colorclickerwebsocketserver.messagemodels.UpdatePlayerScore;
import com.google.gson.Gson;

public class UpdatePlayerScoreHandler {
    IColorClickerClientGameLogic game;

    public UpdatePlayerScoreHandler(IColorClickerClientGameLogic game) {
        this.game = game;
    }

    public void updatePlayerScore(String data) {
        Gson gson = new Gson();
        UpdatePlayerScore updatePlayerScore = gson.fromJson(data, UpdatePlayerScore.class);
        game.UpdatePlayerScore(updatePlayerScore.getPlayer(), updatePlayerScore.getScore());
    }
}

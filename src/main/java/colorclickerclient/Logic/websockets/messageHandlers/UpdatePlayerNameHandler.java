package colorclickerclient.Logic.websockets.messageHandlers;

import colorclickerclient.Logic.IColorClickerClientGameLogic;
import colorclickerwebsocketserver.messagemodels.UpdatePlayerName;
import com.google.gson.Gson;

public class UpdatePlayerNameHandler {
    IColorClickerClientGameLogic game;

    public UpdatePlayerNameHandler(IColorClickerClientGameLogic game) {
        this.game = game;
    }

    public void updatePlayerName(String data) {
        Gson gson = new Gson();
        UpdatePlayerName updatePlayerName = gson.fromJson(data, UpdatePlayerName.class);
        game.UpdatePlayerName(updatePlayerName.getPlayer());
    }
}

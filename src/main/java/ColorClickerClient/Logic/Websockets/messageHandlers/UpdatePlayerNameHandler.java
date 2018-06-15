package ColorClickerClient.Logic.Websockets.messageHandlers;

import ColorClickerClient.Logic.IColorClickerClientGameLogic;
import ColorClickerWebsocketServer.MessageModels.UpdatePlayerName;
import ColorClickerWebsocketServer.MessageModels.UpdatePlayerScore;
import com.google.gson.Gson;

public class UpdatePlayerNameHandler {
    IColorClickerClientGameLogic game;

    public UpdatePlayerNameHandler(IColorClickerClientGameLogic game) {
        this.game = game;
    }

    public void updatePlayerName(String data){
        Gson gson = new Gson();
        UpdatePlayerName updatePlayerName = gson.fromJson(data, UpdatePlayerName.class);
        game.UpdatePlayerName(updatePlayerName.getPlayer());
    }
}

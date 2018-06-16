package colorclickerclient.Logic.websockets.messageHandlers;

import colorclickerclient.Logic.IColorClickerClientGameLogic;
import colorclickerwebsocketserver.messagemodels.CreateGameReceive;
import com.google.gson.Gson;

public class CreateGameReceiveHandler {
    IColorClickerClientGameLogic game;

    public CreateGameReceiveHandler(IColorClickerClientGameLogic game) {
        this.game = game;
    }

    public void createGame(String data) {
        Gson gson = new Gson();
        CreateGameReceive createGameReceive = gson.fromJson(data, CreateGameReceive.class);

        game.CreateGameReceive(createGameReceive.getGameID(), createGameReceive.getPlayerName());
    }
}

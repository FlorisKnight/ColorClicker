package colorclickerwebsocketserver.messagehandlers;

import colorclickerclient.Logic.websockets.messagemodels.CreateGame;
import colorclickerwebsocketserver.IColorClickerWebsocketLogic;
import com.google.gson.Gson;

public class CreateGameHandler {
    IColorClickerWebsocketLogic logic;

    public CreateGameHandler(IColorClickerWebsocketLogic logic) {
        this.logic = logic;
    }

    public void createGame(String data, String sessionId) {
        Gson gson = new Gson();
        CreateGame createGame = gson.fromJson(data, CreateGame.class);
        logic.CreateGame(createGame.getGametype(), createGame.getUserId(), sessionId);
    }
}

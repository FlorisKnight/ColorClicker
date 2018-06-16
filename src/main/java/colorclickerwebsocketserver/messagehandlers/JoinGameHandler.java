package colorclickerwebsocketserver.messagehandlers;

import colorclickerclient.Logic.websockets.messagemodels.JoinGame;
import colorclickerwebsocketserver.IColorClickerWebsocketLogic;
import com.google.gson.Gson;

public class JoinGameHandler {
    IColorClickerWebsocketLogic logic;

    public JoinGameHandler(IColorClickerWebsocketLogic logic) {
        this.logic = logic;
    }

    public void joinGame(String data, String sessionId) {
        Gson gson = new Gson();
        JoinGame joinGame = gson.fromJson(data, JoinGame.class);
        logic.JoinGame(joinGame.getGameID(), joinGame.getUserId(), sessionId);
    }
}

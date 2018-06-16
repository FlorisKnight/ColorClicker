package colorclickerclient.Logic.websockets.messageHandlers;

import colorclickerclient.Logic.IColorClickerClientGameLogic;
import colorclickerwebsocketserver.messagemodels.JoinGameReceive;
import com.google.gson.Gson;

public class JoinGameReceiveHandler {
    IColorClickerClientGameLogic game;

    public JoinGameReceiveHandler(IColorClickerClientGameLogic game) {
        this.game = game;
    }

    public void joinGame(String data) {
        Gson gson = new Gson();
        JoinGameReceive joinGameReceive = gson.fromJson(data, JoinGameReceive.class);

        game.JoinGameReceived(joinGameReceive.getGameID(), joinGameReceive.getPlayer1Name(), joinGameReceive.getPlayer2Name());
    }
}

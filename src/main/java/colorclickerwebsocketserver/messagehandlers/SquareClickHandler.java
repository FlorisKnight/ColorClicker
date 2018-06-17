package colorclickerwebsocketserver.messagehandlers;

import colorclickerclient.Logic.websockets.messagemodels.SquareClick;
import colorclickerwebsocketserver.ColorClickerWebsocketGameLogic;
import colorclickerwebsocketserver.IColorClickerWebsocketGameLogic;
import colorclickerwebsocketserver.IColorClickerWebsocketLogic;
import com.google.gson.Gson;

public class SquareClickHandler {
    IColorClickerWebsocketLogic logic;

    public SquareClickHandler(IColorClickerWebsocketLogic logic) {
        this.logic = logic;
    }

    public void squareClick(String data, String sessionId) {
        Gson gson = new Gson();
        SquareClick squareClick = gson.fromJson(data, SquareClick.class);
        IColorClickerWebsocketGameLogic game = logic.getGame(sessionId);
        if (game != null) {
            game.SquareClick(sessionId, squareClick.getxPos(), squareClick.getyPos());
        }
    }
}

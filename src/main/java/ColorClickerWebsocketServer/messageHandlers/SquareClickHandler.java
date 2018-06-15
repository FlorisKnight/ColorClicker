package ColorClickerWebsocketServer.messageHandlers;

import ColorClickerClient.Logic.Websockets.MessageModels.SquareClick;
import ColorClickerWebsocketServer.ColorClickerWebsocketGameLogic;
import ColorClickerWebsocketServer.IColorClickerWebsocketLogic;
import com.google.gson.Gson;

public class SquareClickHandler {
    IColorClickerWebsocketLogic logic;

    public SquareClickHandler(IColorClickerWebsocketLogic logic) {
        this.logic = logic;
    }

    public void squareClick(String data, String sessionId){
        Gson gson = new Gson();
        SquareClick squareClick = gson.fromJson(data, SquareClick.class);
        ColorClickerWebsocketGameLogic game = logic.getGame(sessionId);
        if (game != null){
            game.SquareClick(sessionId, squareClick.getxPos(), squareClick.getyPos());
        }
    }
}

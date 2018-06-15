package ColorClickerClient.Logic.Websockets.messageHandlers;

import ColorClickerClient.Logic.IColorClickerClientGameLogic;
import ColorClickerWebsocketServer.MessageModels.UpdateSquare;
import com.google.gson.Gson;

public class UpdateSquaresHandler {
    IColorClickerClientGameLogic game;

    public UpdateSquaresHandler(IColorClickerClientGameLogic game) {
        this.game = game;
    }

    public void updateSquares(String data){
        Gson gson = new Gson();
        UpdateSquare updateSquare = gson.fromJson(data, UpdateSquare.class);
        game.UpdateSquares(updateSquare.getxPos(), updateSquare.getyPos(), updateSquare.getColor());
    }

}

package ColorClickerClient.Logic.Websockets.messageHandlers;

import ColorClickerClient.Logic.IColorClickerClientGameLogic;
import ColorClickerWebsocketServer.MessageModels.CreateGameReceive;
import ColorClickerWebsocketServer.MessageModels.EndGame;
import com.google.gson.Gson;

public class EndGameHandler {
    IColorClickerClientGameLogic game;

    public EndGameHandler(IColorClickerClientGameLogic game) {
        this.game = game;
    }

    public void endGame(String data){
        Gson gson = new Gson();
        EndGame endGame = gson.fromJson(data, EndGame.class);

        game.EndGame(endGame.getName());
    }
}

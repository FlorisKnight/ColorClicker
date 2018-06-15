package ColorClickerClient.Logic.Websockets.messageHandlers;

import ColorClickerClient.Logic.IColorClickerClientGameLogic;
import ColorClickerClient.Logic.Websockets.MessageModels.CreateGame;
import ColorClickerWebsocketServer.MessageModels.CreateGameReceive;
import Shared.jsonMessage;
import com.google.gson.Gson;

public class CreateGameReceiveHandler {
    IColorClickerClientGameLogic game;

    public CreateGameReceiveHandler(IColorClickerClientGameLogic game) {
        this.game = game;
    }

    public void createGame(String data){
        Gson gson = new Gson();
        CreateGameReceive createGameReceive = gson.fromJson(data, CreateGameReceive.class);

        game.CreateGameReceive(createGameReceive.getGameID(), createGameReceive.getPlayerName());
    }
}

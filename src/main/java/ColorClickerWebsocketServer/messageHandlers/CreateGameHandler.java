package ColorClickerWebsocketServer.messageHandlers;

import ColorClickerClient.Logic.Websockets.MessageModels.CreateGame;
import ColorClickerWebsocketServer.IColorClickerWebsocketLogic;
import ColorClickerWebsocketServer.REST.dtoWebsockets.GetPlayerRequestDto;
import com.google.gson.Gson;

public class CreateGameHandler {
    IColorClickerWebsocketLogic logic;

    public CreateGameHandler(IColorClickerWebsocketLogic logic) {
        this.logic = logic;
    }

    public void createGame(String data, String sessionId){
        Gson gson = new Gson();
        CreateGame createGame = gson.fromJson(data, CreateGame.class);
        logic.CreateGame(createGame.getGametype(), createGame.getUserId(), sessionId);
    }
}

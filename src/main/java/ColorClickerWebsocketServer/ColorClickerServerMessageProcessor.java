package ColorClickerWebsocketServer;

import ColorClickerWebsocketServer.messageHandlers.CreateGameHandler;
import ColorClickerWebsocketServer.messageHandlers.JoinGameHandler;
import ColorClickerWebsocketServer.messageHandlers.SquareClickHandler;
import ColorClickerClient.Logic.Websockets.IColorClickerMessageProcessor;
import ColorClickerClient.Logic.Websockets.MessageModels.CreateGame;
import ColorClickerClient.Logic.Websockets.MessageModels.JoinGame;
import ColorClickerClient.Logic.Websockets.MessageModels.SquareClick;
import Shared.jsonMessage;
import com.google.gson.Gson;

public class ColorClickerServerMessageProcessor implements IColorClickerWebsocketServerMessageProcessor {
    IColorClickerWebsocketLogic logic;

    public ColorClickerServerMessageProcessor(IColorClickerWebsocketLogic logic) {
        this.logic = logic;
    }

    @Override
    public void processMessage(String msg, String sessionId) {
        Gson gson = new Gson();
        jsonMessage messageObject = gson.fromJson(msg, jsonMessage.class);

        switch (messageObject.getMessage()) {
            case "CreateGame":
                CreateGameHandler createGameHandler = new CreateGameHandler(logic);
                createGameHandler.createGame(messageObject.getObject(), sessionId);
                break;
            case "JoinGame":
                JoinGameHandler joinGameHandler = new JoinGameHandler(logic);
                joinGameHandler.joinGame(messageObject.getObject(), sessionId);
                break;
            case "SquareClick":
                SquareClickHandler squareClickHandler = new SquareClickHandler(logic);
                squareClickHandler.squareClick(messageObject.getObject(), sessionId);
                break;
        }
    }
}

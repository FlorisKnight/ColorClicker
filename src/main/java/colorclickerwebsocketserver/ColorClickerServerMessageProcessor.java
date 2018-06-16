package colorclickerwebsocketserver;

import colorclickerwebsocketserver.messagehandlers.CreateGameHandler;
import colorclickerwebsocketserver.messagehandlers.JoinGameHandler;
import colorclickerwebsocketserver.messagehandlers.SquareClickHandler;
import com.google.gson.Gson;
import shared.jsonMessage;

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
            default:
                System.out.println("Unknown action");
                break;
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

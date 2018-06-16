package colorclickerclient.Logic.websockets;

import colorclickerclient.Logic.IColorClickerClientGameLogic;
import colorclickerclient.Logic.websockets.messageHandlers.*;
import com.google.gson.Gson;
import shared.jsonMessage;

public class ColorClickerClientMessageProcessor implements IColorClickerMessageProcessor {
    IColorClickerClientGameLogic game;

    public ColorClickerClientMessageProcessor(IColorClickerClientGameLogic game) {
        this.game = game;
    }

    @Override
    public void processMessage(String msg) {
        Gson gson = new Gson();
        jsonMessage messageObject = gson.fromJson(msg, jsonMessage.class);

        switch (messageObject.getMessage()) {
            default:
                System.out.println("Unknown action");
                break;
            case "CreateGameReceive":
                CreateGameReceiveHandler createGameReceiveHandler = new CreateGameReceiveHandler(game);
                createGameReceiveHandler.createGame(messageObject.getObject());
                break;
            case "JoinGameReceive":
                JoinGameReceiveHandler joinGameReceiveHandler = new JoinGameReceiveHandler(game);
                joinGameReceiveHandler.joinGame(messageObject.getObject());
                break;
            case "EndGameMessage":
                EndGameHandler endGameHandler = new EndGameHandler(game);
                endGameHandler.endGame(messageObject.getObject());
                break;
            case "UpdateSquares":
                UpdateSquaresHandler updateSquaresHandler = new UpdateSquaresHandler(game);
                updateSquaresHandler.updateSquares(messageObject.getObject());
                break;
            case "UpdatePlayerScore":
                UpdatePlayerScoreHandler updatePlayerScoreHandler = new UpdatePlayerScoreHandler(game);
                updatePlayerScoreHandler.updatePlayerScore(messageObject.getObject());
                break;
            case "UpdatePlayerName":
                UpdatePlayerNameHandler updatePlayerNameHandler = new UpdatePlayerNameHandler(game);
                updatePlayerNameHandler.updatePlayerName(messageObject.getObject());
                break;
        }
    }
}

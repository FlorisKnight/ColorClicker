package Stubs;

import colorclickerclient.Logic.websockets.IColorClickerMessageProcessor;
import colorclickerclient.Logic.websockets.messageHandlers.*;
import colorclickerclient.Logic.websockets.messagemodels.CreateGame;
import colorclickerwebsocketserver.messagemodels.*;
import com.google.gson.Gson;
import shared.jsonMessage;

public class ColorClickerClientMessageProcessorStub implements IColorClickerMessageProcessor, IColorClickerClientMessageProcessorStubGetters {
    String createGameReceive;
    String joinGameReceive;
    String endGame;
    String updateSquare;
    String updatePlayerScore;
    String updatePlayerName;

    @Override
    public void processMessage(String msg) {
        Gson gson = new Gson();
        jsonMessage messageObject = gson.fromJson(msg, jsonMessage.class);

        switch (messageObject.getMessage()) {
            default:
                System.out.println("Unknown action");
                break;
            case "CreateGameReceive":
                createGameReceive = messageObject.getObject();
                break;
            case "JoinGameReceive":
                joinGameReceive = messageObject.getObject();
                break;
            case "EndGameMessage":
                endGame = messageObject.getObject();
                break;
            case "UpdateSquares":
                updateSquare = messageObject.getObject();
                break;
            case "UpdatePlayerScore":
                updatePlayerScore = messageObject.getObject();
                break;
            case "UpdatePlayerName":
                updatePlayerName = messageObject.getObject();
                break;
        }
}

    public String getCreateGameReceive() {
        return createGameReceive;
    }

    public String getJoinGameReceive() {
        return joinGameReceive;
    }

    public String getEndGame() {
        return endGame;
    }

    public String getUpdateSquare() {
        return updateSquare;
    }

    public String getUpdatePlayerScore() {
        return updatePlayerScore;
    }

    public String getUpdatePlayerName() {
        return updatePlayerName;
    }
}

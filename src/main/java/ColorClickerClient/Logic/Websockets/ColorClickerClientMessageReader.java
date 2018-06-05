package ColorClickerClient.Logic.Websockets;

import ColorClickerClient.Logic.ColorClickerClientLogic;
import WebsocketModels.*;
import com.google.gson.Gson;


public class ColorClickerClientMessageReader implements IColorClickerClientWebsocketMessageReader{
    ColorClickerClientLogic logic;
    public ColorClickerClientMessageReader(ColorClickerClientLogic logic){
        this.logic=logic;

    }
    public void MessageReader(String serverMessage){
        Gson gson = new Gson();
        jsonMessage messageObject = gson.fromJson(serverMessage, jsonMessage.class);

        switch (messageObject.getMessage()) {
            case "CreateGameReceive":  logic.CreateGameReceive(((CreateGameReceive)messageObject.getObject()));break;
            case "JoinGameReceive": logic.JoinGameReceived(((JoinGameReceive)messageObject.getObject())); break;
            case "EndGame": logic.EndGame(((String)messageObject.getObject()));break;
            case "UpdateSquares": logic.UpdateSquares(((UpdateSquare)messageObject.getObject()));break;
            case "UpdatePlayerScore": logic.UpdatePlayerScore(((UpdatePlayerScore)messageObject.getObject()));break;
            case "UpdatePlayerName": logic.UpdatePlayerName((String)messageObject.getObject());break;
            case "UpdateTime": logic.UpdateTime((int)messageObject.getObject());break;
        }
    }

}
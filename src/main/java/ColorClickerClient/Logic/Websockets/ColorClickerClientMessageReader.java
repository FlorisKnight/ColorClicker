package ColorClickerClient.Logic.Websockets;

import ColorClickerClient.Logic.ColorClickerClientLogic;
import ColorClickerClient.Logic.IColorClickerClientLogic;
import ColorClickerClient.View.sceneGame;
import WebsocketModels.EndGame;
import WebsocketModels.UpdateSquare;
import com.google.gson.Gson;
import WebsocketModels.jsonMessage;


public class ColorClickerClientMessageReader implements IColorClickerClientWebsocketMessageReader{
    ColorClickerClientLogic logic;
    public ColorClickerClientMessageReader(ColorClickerClientLogic logic){
        this.logic=logic;

    }
    public void MessageReader(String serverMessage){
        Gson gson = new Gson();
        jsonMessage messageObject = gson.fromJson(serverMessage, jsonMessage.class);

        switch (messageObject.getMessage()) {
            case "CreateGameReceive": break;
            case "JoinGameReceive": break;
            case "EndGame": logic.EndGame(((EndGame)messageObject.getObject()).getPlayerName());break;
            case "UpdateSquares": logic.UpdateSquares(((UpdateSquare)messageObject.getObject()).getColor(),((UpdateSquare)messageObject.getObject()).getxPos(),((UpdateSquare)messageObject.getObject()).getyPos());break;
            case "UpdateTime": break;
            case "UpdatePlayer": break;
        }
    }

}
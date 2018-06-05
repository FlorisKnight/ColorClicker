package ColorClickerWebsocketServer;

import WebsocketModels.*;
import com.google.gson.Gson;

public class ColorClickerWebsocketMessageReader implements IColorClickerWebsocketMessageReader{
    IColorClickerWebsocketLogic logic;

    public ColorClickerWebsocketMessageReader(IColorClickerWebsocketLogic logic){
        this.logic = logic;
    }

    public void MessageReader(String serverMessage, String sessionId){
        Gson gson = new Gson();
        WebsocketModels.jsonMessage messageObject = gson.fromJson(serverMessage, jsonMessage.class);

        switch (messageObject.getMessage()) {
            case "CreateGame":  logic.CreateGame(((CreateGame)messageObject.getObject()), sessionId);break;
            case "JoinGame": logic.JoinGame(((JoinGame)messageObject.getObject()), sessionId); break;
            case "SquareClick": logic.SquareClick(((SquareClick)messageObject.getObject()), sessionId);break;
        }
    }
}

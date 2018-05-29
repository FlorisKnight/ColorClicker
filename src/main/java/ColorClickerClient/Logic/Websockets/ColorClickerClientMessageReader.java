package ColorClickerClient.Logic.Websockets;

import com.google.gson.Gson;
import WebsocketModels.jsonMessage;


public class ColorClickerClientMessageReader implements IColorClickerClientWebsocketMessageReader{

    public void MessageReader(String serverMessage){
        Gson gson = new Gson();
        jsonMessage messageObject = gson.fromJson(serverMessage, jsonMessage.class);

        //TODO Convert To Int????
        switch (messageObject.getMessage()) {
            case "CreateGameReceive": break;
            case "JoinGameReceive": break;
            case "EndGame": break;
            case "NewGame": break;
            case "UpdateSquares": break;
            case "UpdateTime": break;
            case "UpdatePlayer": break;
        }
    }

}
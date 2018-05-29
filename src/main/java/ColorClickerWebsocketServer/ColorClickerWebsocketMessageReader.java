package ColorClickerWebsocketServer;

import WebsocketModels.jsonMessage;
import com.google.gson.Gson;

public class ColorClickerWebsocketMessageReader {
    public void MessageReader(String serverMessage){
        Gson gson = new Gson();
        jsonMessage messageObject = gson.fromJson(serverMessage, jsonMessage.class);

        //TODO Convert To Int????
        switch (messageObject.getMessage()) {
            case "CreateGame": break;
            case "JoinGame": break;
            case "SquareClick": break;
        }
    }
}
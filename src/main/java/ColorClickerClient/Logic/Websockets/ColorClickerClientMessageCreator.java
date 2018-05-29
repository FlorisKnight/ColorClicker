package ColorClickerClient.Logic.Websockets;

import WebsocketModels.jsonMessage;
import com.google.gson.Gson;

public class ColorClickerClientMessageCreator implements IColorClickerClientWebsocketMessageCreator{

    public String MessageCreator(String action, Object object){
        Gson gson = new Gson();
        return gson.toJson(new jsonMessage(action, object));
    }
}
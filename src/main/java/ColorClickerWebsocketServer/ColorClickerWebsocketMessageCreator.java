package ColorClickerWebsocketServer;

import WebsocketModels.jsonMessage;
import com.google.gson.Gson;

public class ColorClickerWebsocketMessageCreator {
    public String MessageCreator(String action, Object object){
        Gson gson = new Gson();
        return gson.toJson(new jsonMessage(action, object));
    }
}
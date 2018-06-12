package ColorClickerClient.Logic.Websockets;

import WebsocketModels.jsonMessage;
import com.google.gson.Gson;

public class ColorClickerClientMessageCreator implements IColorClickerClientWebsocketMessageCreator{
    public ColorClickerClientMessageCreator(clienntSocket){

    }

    public void MessageCreator(String action, Object object){
        Gson gson = new Gson();
        String message = gson.toJson(new jsonMessage(action, object));
    }
}
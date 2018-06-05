package ColorClickerWebsocketServer;

import WebsocketModels.jsonMessage;
import com.google.gson.Gson;

public class ColorClickerWebsocketMessageCreator implements IColorClickerWebsocketMessageCreator{
    ColorClickerEventServerSocket eventSockets;

    public ColorClickerWebsocketMessageCreator(ColorClickerEventServerSocket eventSockets){
        this.eventSockets = eventSockets;
    }

    public void MessageCreator(String action, Object object, String sessionId){
        Gson gson = new Gson();
        eventSockets.sendMessage(gson.toJson(new jsonMessage(action, object)), sessionId);
    }
}

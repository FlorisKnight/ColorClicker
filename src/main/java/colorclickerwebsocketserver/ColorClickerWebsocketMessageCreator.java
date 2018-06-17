package colorclickerwebsocketserver;

import com.google.gson.Gson;
import shared.jsonMessage;

public class ColorClickerWebsocketMessageCreator implements IColorClickerWebsocketMessageCreator {
    IColorClickerEventServerSocket eventSockets;

    public ColorClickerWebsocketMessageCreator(IColorClickerEventServerSocket eventSockets) {
        this.eventSockets = eventSockets;
    }

    public void MessageCreator(String action, String object, String sessionId) {
        Gson gson = new Gson();
        eventSockets.sendMessage(gson.toJson(new jsonMessage(action, object)), sessionId);
    }
}

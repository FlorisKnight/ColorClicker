package colorclickerclient.Logic.websockets;

import com.google.gson.Gson;
import shared.jsonMessage;

public class ColorClickerClientMessageCreator implements IColorClickerClientWebsocketMessageCreator {
    IColorClickerEventClientSocket clientSocket;

    public ColorClickerClientMessageCreator(IColorClickerEventClientSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void MessageCreator(String action, String object) {
        Gson gson = new Gson();
        String message = gson.toJson(new jsonMessage(action, object));
        clientSocket.sendMessageToServer(message);
    }
}
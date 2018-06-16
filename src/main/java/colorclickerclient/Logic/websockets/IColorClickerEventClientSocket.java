package colorclickerclient.Logic.websockets;

import javax.websocket.CloseReason;

public interface IColorClickerEventClientSocket {
    void start();

    void onWebSocketConnect();

    void onWebSocketText(String message);

    void onWebSocketClose(CloseReason reason);

    void onWebSocketError(Throwable cause);

    void sendMessageToServer(String message);

    void stop();
}

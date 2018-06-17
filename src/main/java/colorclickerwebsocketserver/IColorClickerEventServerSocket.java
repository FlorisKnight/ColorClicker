package colorclickerwebsocketserver;

import javax.websocket.CloseReason;
import javax.websocket.Session;

public interface IColorClickerEventServerSocket {

    void onConnect(Session session);

    void onText(String message, Session session);

    void onClose(CloseReason reason, Session session);

    void onError(Throwable cause, Session session);

    void sendMessage(String message,String sessionId);

}

package colorclickerwebsocketserver;

public interface IColorClickerWebsocketServerMessageProcessor {
    void processMessage(String msg, String sessionId);
}

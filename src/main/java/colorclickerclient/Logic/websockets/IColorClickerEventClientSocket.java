package colorclickerclient.Logic.websockets;

public interface IColorClickerEventClientSocket {
    void start();

    void sendMessageToServer(String message);

    void stop();
}

package ColorClickerClient.Logic.Websockets;

public interface IColorClickerEventClientSocket {
    void start();

    void sendMessageToServer(String message);

    void stop();
}

package ColorClickerClient.Logic.Websockets;

public interface IColorClickerClientWebsocketMessageReader {

    /**
     *
     * @param jsonMessage
     */
    public void MessageReader(String jsonMessage);

}
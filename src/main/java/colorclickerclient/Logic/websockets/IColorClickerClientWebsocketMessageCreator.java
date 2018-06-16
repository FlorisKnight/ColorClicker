package colorclickerclient.Logic.websockets;

public interface IColorClickerClientWebsocketMessageCreator {

    /**
     * @param action
     * @param object
     */
    public void MessageCreator(String action, String object);

}
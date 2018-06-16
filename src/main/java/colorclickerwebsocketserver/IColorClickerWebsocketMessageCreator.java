package colorclickerwebsocketserver;

public interface IColorClickerWebsocketMessageCreator {

    /**
     * @param action
     * @param object
     * @param sessionId
     */
    public void MessageCreator(String action, String object, String sessionId);

}
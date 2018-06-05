package ColorClickerWebsocketServer;

public interface IColorClickerWebsocketMessageCreator {

	/**
	 * 
	 * @param action
	 * @param object
	 * @param sessionId
	 */
	public void MessageCreator(String action, Object object, String sessionId);

}
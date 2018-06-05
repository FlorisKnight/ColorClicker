package ColorClickerWebsocketServer;

public interface IColorClickerWebsocketMessageReader {

	/**
	 * 
	 * @param serverMessage
	 * @param sessionId
	 */
	public void MessageReader(String serverMessage, String sessionId);
}
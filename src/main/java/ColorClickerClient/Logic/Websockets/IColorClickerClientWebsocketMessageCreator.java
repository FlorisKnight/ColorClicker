package ColorClickerClient.Logic.Websockets;

public interface IColorClickerClientWebsocketMessageCreator {

	/**
	 * 
	 * @param action
	 * @param object
	 */
	public void MessageCreator(String action, String object);

}
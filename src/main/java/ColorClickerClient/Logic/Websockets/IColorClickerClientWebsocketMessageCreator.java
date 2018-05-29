package ColorClickerClient.Logic.Websockets;

public interface IColorClickerClientWebsocketMessageCreator {

	/**
	 * 
	 * @param action
	 * @param object
	 */
	public String MessageCreator(String action, Object object);

}
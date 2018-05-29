package ColorClickerClient.Logic.REST;

public interface IColorClickerClientRESTLogic {

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public void Login(char email, char password);

	/**
	 * 
	 * @param path
	 * @param value
	 */
	public void Message(char path, char value);

}
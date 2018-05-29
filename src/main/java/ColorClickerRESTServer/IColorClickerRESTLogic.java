package ColorClickerRESTServer;

public interface IColorClickerRESTLogic {

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public int SignIn(char email, char password);

	/**
	 * 
	 * @param email
	 * @param password
	 * @param name
	 */
	public int SignUp(char email, char password, char name);

	public String[][] getHighscores();

	/**
	 * 
	 * @param playerScores
	 */
	public boolean saveScores(String[][] playerScores);

}
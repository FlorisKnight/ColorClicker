package ColorClickerClient.Logic;

import Models.Color;

public interface IColorClickerClientLogic {

	/**
	 * 
	 * @param email
	 * @param password
	 */
	public int SignIn(String email, String password);

	/**
	 * 
	 * @param email
	 * @param password
	 * @param name
	 */
	public void SignUp(String email, String password, String name);

	/**
	 * 
	 * @param gametype
	 */
	public void CreateGame(int gametype);

	/**
	 * 
	 * @param gameCode
	 */
	public void JoinGame(String gameCode);

	public String[][] GetHighscores();

	/**
	 * 
	 * @param xPos
	 * @param yPos
	 */
	public void SquareClick(int xPos, int yPos);

	public void EndGame();

	public void NewGame();

	/**
	 * 
	 * @param squareColor
	 * @param yPos
	 * @param YPos
	 */
	public void UpdateSquares(Color squareColor, int yPos, int YPos);

	/**
	 * 
	 * @param squareColor
	 */
	public void SelectColor(Color squareColor);


}
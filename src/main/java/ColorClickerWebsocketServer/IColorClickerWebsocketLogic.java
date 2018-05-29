package DiaVDKlasjes.KlassenDiagram;

import Models.Color;

public interface IColorClickerWebsocketLogic {

	/**
	 * @param email
	 * @param password
	 * @param name
	 */
	public int SignUp(String email, String password, String name);

	/**
	 * @param gametype
	 */
	public char CreateGame(int gametype);

	/**
	 * @param gameCode
	 */
	public boolean JoinGame(String gameCode);

	public String[][] GetHighscores();

	/**
	 * @param squareColor
	 */
	public void SelectColor(Color squareColor);

	/**
	 * @param xPos
	 * @param yPos
	 */
	public void SquareClick(int xPos, int yPos);

	public void EndGame();

	/**
	 * @param squareColor
	 * @param xPos
	 * @param yPos
	 */
	public void UpdateSquares(Color squareColor, int xPos, int yPos);
}
package DiaVDKlasjes.KlassenDiagram;

import Models.Color;

public interface IColorClickerWebsocketLogic {

	/**
	 * @param gametype
	 */
	public char CreateGame(int gametype);

	/**
	 * @param gameCode
	 */
	public boolean JoinGame(String gameCode);

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
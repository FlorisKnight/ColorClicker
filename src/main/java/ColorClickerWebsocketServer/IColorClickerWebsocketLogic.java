package ColorClickerWebsocketServer;

import Models.Color;
import Models.Game;
import WebsocketModels.*;

public interface IColorClickerWebsocketLogic {

	/**
	 * @param object
	 */
	public void CreateGame(CreateGame object, String session);

	/**
	 * @param object
	 */
	public void JoinGame(JoinGame object, String session);

	/**
	 * @param object
	 */
	public void SquareClick(SquareClick object, String session);

	public void EndGame(String sessionID, String winner);

	/**
	 * @param squareColor
	 * @param xPos
	 * @param yPos
	 */
	public void UpdateSquares(javafx.scene.paint.Color squareColor, int xPos, int yPos, String sessionID);

	public void RemoveGame(Game game);
}
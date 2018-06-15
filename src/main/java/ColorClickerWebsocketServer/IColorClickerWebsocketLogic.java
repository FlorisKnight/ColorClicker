package ColorClickerWebsocketServer;

import javafx.scene.paint.Color;

public interface IColorClickerWebsocketLogic {

	void setEventSockets(ColorClickerEventServerSocket eventSockets);

	void CreateGame(String gametype, String userId, String sessionId);

	void JoinGame(int gameId, String userId, String sessionId);

	void EndGameMessage(String sessionID, String winner);

	void UpdateSquares(Color squareColor, int xPos, int yPos, String sessionID);

	void RemoveGame(ColorClickerWebsocketGameLogic game);

	ColorClickerWebsocketGameLogic getGame(String sessionId);
}
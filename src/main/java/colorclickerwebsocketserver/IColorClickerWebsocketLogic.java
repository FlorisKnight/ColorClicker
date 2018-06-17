package colorclickerwebsocketserver;

import javafx.scene.paint.Color;

public interface IColorClickerWebsocketLogic {

    void setEventSockets(IColorClickerEventServerSocket eventSockets);

    void CreateGame(String gametype, String userId, String sessionId);

    void JoinGame(int gameId, String userId, String sessionId);

    void EndGameMessage(String sessionID, String winner);

    void UpdateSquares(Color squareColor, int xPos, int yPos, String sessionID);

    void RemoveGame(IColorClickerWebsocketGameLogic game);

    IColorClickerWebsocketGameLogic getGame(String sessionId);

    void UploadScores(String name, int score, String gameType);

    void UpdatePlayerScore(int player, int score, String sessionId);
}
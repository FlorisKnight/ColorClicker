package Stubs;

import colorclickerwebsocketserver.ColorClickerEventServerSocket;
import colorclickerwebsocketserver.ColorClickerWebsocketGameLogic;
import colorclickerwebsocketserver.IColorClickerWebsocketLogic;
import javafx.scene.paint.Color;

public class ColorClickerWebsocketLogicStud implements IColorClickerWebsocketLogic {
    @Override
    public void setEventSockets(ColorClickerEventServerSocket eventSockets) {

    }

    @Override
    public void CreateGame(String gametype, String userId, String sessionId) {

    }

    @Override
    public void JoinGame(int gameId, String userId, String sessionId) {

    }

    @Override
    public void EndGameMessage(String sessionID, String winner) {

    }

    @Override
    public void UpdateSquares(Color squareColor, int xPos, int yPos, String sessionID) {

    }

    @Override
    public void RemoveGame(ColorClickerWebsocketGameLogic game) {

    }

    @Override
    public ColorClickerWebsocketGameLogic getGame(String sessionId) {
        return null;
    }

    @Override
    public void UploadScores(String name, int score, String gameType) {

    }

    @Override
    public void UpdatePlayerScore(int player, int score, String sessionId) {

    }
}

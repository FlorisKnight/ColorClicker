package Stubs;

import colorclickerwebsocketserver.*;
import javafx.scene.paint.Color;

public class ColorClickerWebsocketLogicStub implements IColorClickerWebsocketLogic {
    ColorClickerWebsocketGameLogicStub game = new ColorClickerWebsocketGameLogicStub();

    String gametype;
    String userId;
    String sessionId;
    int gameId;

    @Override
    public void setEventSockets(IColorClickerEventServerSocket eventSockets) {

    }

    @Override
    public void CreateGame(String gametype, String userId, String sessionId) {
        this.gametype = gametype;
        this.userId = userId;
        this.sessionId = sessionId;
    }

    @Override
    public void JoinGame(int gameId, String userId, String sessionId) {
        this.gameId = gameId;
        this.userId = userId;
        this.sessionId = sessionId;
    }

    @Override
    public void EndGameMessage(String sessionID, String winner) {

    }

    @Override
    public void UpdateSquares(Color squareColor, int xPos, int yPos, String sessionID) {

    }

    @Override
    public void RemoveGame(IColorClickerWebsocketGameLogic game) {

    }

    @Override
    public IColorClickerWebsocketGameLogic getGame(String sessionId) {
        return game;
    }

    @Override
    public void UploadScores(String name, int score, String gameType) {

    }

    @Override
    public void UpdatePlayerScore(int player, int score, String sessionId) {

    }

    public ColorClickerWebsocketGameLogicStub getGame() {
        return game;
    }

    public String getGametype() {
        return gametype;
    }

    public String getUserId() {
        return userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public int getGameId() {
        return gameId;
    }

}

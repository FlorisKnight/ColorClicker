package Stubs;

import colorclickerwebsocketserver.IColorClickerWebsocketGameLogic;
import models.Player;

public class ColorClickerWebsocketGameLogicStub implements IColorClickerWebsocketGameLogic {
    String sessionId;
    int xPos;
    int yPos;

    @Override
    public void StartGame() {

    }

    @Override
    public void SquareClick(String sessionID, int xpos, int ypos) {
        this.sessionId = sessionID;
        this. xPos = xpos;
        this.yPos = ypos;
    }

    @Override
    public void AddPlayer(Player player2) {

    }

    @Override
    public boolean checkSessionID(String sessionID) {
        return false;
    }

    @Override
    public int getGameId() {
        return 0;
    }

    @Override
    public String getPlayer1Name() {
        return null;
    }

    @Override
    public String getPlayer2Name() {
        return null;
    }

    @Override
    public String getPlayer1SessionID() {
        return null;
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }

    @Override
    public Player getPlayer2() {
        return null;
    }

    @Override
    public Player[][] getField() {
        return new Player[0][];
    }


    public String getSessionId() {
        return sessionId;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

}

package Stubs;

import colorclickerclient.Logic.IColorClickerClientGameLogic;
import javafx.scene.paint.Color;

public class ColorClickerClientLogicStub implements IColorClickerClientGameLogic {
    int gameId;

    String playername;
    String player1Name;
    String player2Name;
    int xPos;
    int yPos;
    Color color;
    int score;
    int player;

    @Override
    public void CreateGameReceive(int gameId, String playername) {
        this.gameId = gameId;
        this.playername = playername;
    }

    @Override
    public void JoinGameReceived(int gameId, String player1Name, String player2Name) {
        this.gameId = gameId;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void EndGame(String playerName) {
        this.playername = playerName;
    }

    @Override
    public void SquareClick(int xPos, int yPos) {

    }

    @Override
    public void UpdateSquares(int xPos, int yPos, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    @Override
    public void UpdatePlayerScore(int player, int score) {
        this.player = player;
        this.score = score;
    }

    @Override
    public void UpdatePlayerName(String playerName) {
        this.playername = playerName;
    }

    public int getPlayer() {
        return player;
    }

    public int getGameId() {
        return gameId;
    }

    public String getPlayername() {
        return playername;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Color getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }
}

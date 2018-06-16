package colorclickerwebsocketserver;

import colorclickerwebsocketserver.messagemodels.UpdatePlayerScore;
import models.Player;

import java.util.Timer;
import java.util.TimerTask;

public class ColorClickerWebsocketGameLogic implements IColorClickerWebsocketGameLogic {

    int gameId;
    Player player1;
    Player player2;
    int player1FieldAmount;
    int player2FieldAmount;
    Player[][] field;
    Timer timer;
    String gametype;
    long gametime;
    boolean start;

    IColorClickerWebsocketLogic logic;

    public ColorClickerWebsocketGameLogic(int gameId, Player player1, IColorClickerWebsocketLogic logic, String gametype) {
        this.gameId = gameId;
        this.player1 = player1;
        field = new Player[8][8];
        this.logic = logic;
        this.gametype = gametype;
        start = false;
    }

    @Override
    public void SquareClick(String sessionID, int xpos, int ypos) {
        if (start) {
            if (player1.getSessionID().equals(sessionID) && (field[xpos][ypos] == null || !field[xpos][ypos].equals(player1)))
                UpdateSquares(player1, xpos, ypos);
            else if (player2.getSessionID().equals(sessionID) && (field[xpos][ypos] == null || !field[xpos][ypos].equals(player2)))
                UpdateSquares(player2, xpos, ypos);
        }
    }

    @Override
    public void AddPlayer(Player player2) {
        this.player2 = player2;
    }

    @Override
    public boolean checkSessionID(String sessionID) {
        if (sessionID.equals(player1.getSessionID()) || sessionID.equals(player2.getSessionID())) {
            return true;
        }
        return false;
    }

    @Override
    public int getGameId() {
        return gameId;
    }

    @Override
    public String getPlayer1Name() {
        return player1.getName();
    }

    @Override
    public String getPlayer2Name() {
        return player2.getName();
    }

    @Override
    public String getPlayer1SessionID() {
        return player1.getSessionID();
    }

    @Override
    public void StartGame() {
        //Start timer
        if (gametype.equals("Normal"))
            gametime = 60;
        else if (gametype.equals("Fast"))
            gametime = 30;

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                EndGame();
            }
        }, 1 * gametime * 1000);
        start = true;
    }

    @Override
    public boolean checkAvailability() {
        if (player2 == null)
            return true;
        else
            return false;
    }

    private String getWinner() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (field[i][j] instanceof Player) {
                    if (field[i][j].equals(player1)) {
                        player1FieldAmount++;
                    } else if (field[i][j].equals(player2)) {
                        player2FieldAmount++;
                    }
                }
            }
        }

        if (player1FieldAmount > player2FieldAmount) {
            player1.addScore(10);
        } else {
            player2.addScore(10);
        }

        if (player1.getScore() > player2.getScore()) {
            return player1.getName();
        } else {
            return player2.getName();
        }
    }

    private void addScore(Player player, int xpos, int ypos) {
        if (field[xpos][ypos] == null || field[xpos][ypos] instanceof Player) {
            player.addScore(1);
        }
    }

    private void UpdateSquares(Player player, int xpos, int ypos) {
            addScore(player, xpos, ypos);
            logic.UpdateSquares(player.getColor(), xpos, ypos, player1.getSessionID());
            logic.UpdateSquares(player.getColor(), xpos, ypos, player2.getSessionID());

            if (player == player1){
                logic.UpdatePlayerScore(0, player1.getScore(), player1.getSessionID());
                logic.UpdatePlayerScore(0, player1.getScore(), player2.getSessionID());
            }
            else if (player == player2){
                logic.UpdatePlayerScore(1, player2.getScore(), player1.getSessionID());
                logic.UpdatePlayerScore(1, player2.getScore(), player2.getSessionID());
            }


        field[xpos][ypos] = player;
    }

    private void EndGame() {
        String winner = getWinner();
        logic.EndGameMessage(player1.getSessionID(), winner);
        logic.EndGameMessage(player2.getSessionID(), winner);
        logic.UploadScores(player1.getName(), player1.getScore(), gametype);
        logic.UploadScores(player2.getName(), player2.getScore(), gametype);
        logic.RemoveGame(this);
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player[][] getField() {
        return field;
    }
}

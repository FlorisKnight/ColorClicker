package Models;

import ColorClickerWebsocketServer.ColorClickerWebsocketRandomSquare;
import ColorClickerWebsocketServer.IColorClickerWebsocketLogic;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game{
    int gameId;
    Player player1;
    Player player2;
    int player1FieldAmount;
    int player2FieldAmount;
    Object[][] field;
    Timer timer;
    Thread randomSquare;
    Random r;

    IColorClickerWebsocketLogic logic;

    public Game(int gameId, Player player1, IColorClickerWebsocketLogic logic, String gametype){
        this.gameId = gameId;
        this.player1 = player1;
        field = new Object[8][8];
        this.logic = logic;
        r = new Random();
        if (gametype != "classic")
            randomSquare = new Thread(new ColorClickerWebsocketRandomSquare(this, gametype));
    }

    public void AddPlayer(Player player2){
        StartGame();
    }

    public void StartGame(){
        //Start timer
        timer = new Timer();
        if (randomSquare != null)
            randomSquare.start();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                EndGame();
                if (randomSquare != null)
                    randomSquare.interrupt();
            }
        }, 1*60*1000);
    }

    public String getWinner(){
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                if (field[i][j] instanceof Player) {
                    if (field[i][j].equals(player1)){
                        player1FieldAmount++;
                    } else if (field[i][j].equals(player2)){
                        player2FieldAmount++;
                    }
                }
            }
        }

        if (player1FieldAmount > player2FieldAmount){
            player1.addScore(10);
        } else {
            player2.addScore(10);
        }

        if (player1.getScore() > player2.getScore()){
            return player1.getName();
        } else {
            return player2.getName();
        }
    }

    public void SquareClick(String sessionID, int xpos, int ypos){
        if (player1.getSessionID().equals(sessionID) && !field[xpos][ypos].equals(player1))
            UpdateSquares(player1, xpos, ypos);
        else if(player2.getSessionID().equals(sessionID) && !field[xpos][ypos].equals(player2))
            UpdateSquares(player2, xpos, ypos);
    }

    private void addScore(Player player, int xpos, int ypos){
        if (field[xpos][ypos] instanceof Color){
            Color color = (Color)field[xpos][ypos];
            player.addScore(color.getPoint());
        } else if(field[xpos][ypos].equals(player)){
            player.addScore(1);
        }
    }

    private void UpdateSquares(Object object, int xpos, int ypos){
        if (object instanceof Player){
            addScore(player, xpos, ypos);
        }
        field[xpos][ypos] = object;
        logic.UpdateSquares(player.getColor(), xpos, ypos, player.getSessionID());
    }

    public boolean checkSessionID(String sessionID){
        if (sessionID.equals(player1.getSessionID()) || sessionID.equals(player2.getSessionID())){
            return true;
        }
        return false;
    }

    public int getGameId() {
        return gameId;
    }

    public String getPlayer1Name(){
        return  player1.getName();
    }

    public String getPlayer2Name(){
        return  player2.getName();
    }

    public String getPlayer1SessionID(){
        return  player1.getSessionID();
    }

    public void placeRandomSquare(){
            int color = r.nextInt(3);
            switch (color){
                case 0:;
                case 1:;
                case 2:;
            }
    }

    public void EndGame(){
        logic.EndGame(player1.getSessionID(), getWinner());
        logic.EndGame(player2.getSessionID(), getWinner());
        logic.RemoveGame(this);
    }
}

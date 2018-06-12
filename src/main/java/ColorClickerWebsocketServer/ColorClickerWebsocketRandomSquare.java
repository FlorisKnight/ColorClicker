package ColorClickerWebsocketServer;

import Models.Game;

import java.util.Random;

public class ColorClickerWebsocketRandomSquare implements Runnable {
    int MIN_TICKS = 2;
    int MAX_TICKS = 12;
    boolean running = false;
    Random r = new Random();
    Game game;
    String gametype;

    public ColorClickerWebsocketRandomSquare(Game game, String gametype){
        this.game = game;
        this.gametype = gametype;
        switch(gametype){
            case "Normal":
                MIN_TICKS = 4;
                MAX_TICKS = 15;
                break;
            case "Fast":
                MIN_TICKS = 1;
                MAX_TICKS = 8;
                break;
        }
    }

    @Override
    public void run(){
        double method_tick = nextMethodTime();
        while (running){
            if (System.currentTimeMillis() > method_tick){
                //call method
                game.placeRandomSquare();
                //update time
                method_tick = nextMethodTime();
            }
        }
    }

    public double nextMethodTime(){
        return System.currentTimeMillis() + (MIN_TICKS + r.nextInt(MAX_TICKS - MIN_TICKS) * r.nextDouble()) * 1000;
    }
}

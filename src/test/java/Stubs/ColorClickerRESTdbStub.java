package Stubs;

import colorclickerrestserver.IColorClickerRestDB;
import models.Score;

import java.util.ArrayList;
import java.util.List;

public class ColorClickerRESTdbStub implements IColorClickerRestDB{
    @Override
    public List<Score> getHighscores() {
        return new ArrayList<Score>();
    }

    @Override
    public boolean setHighscores(String playerName, int score, String gametype) {
        return true;
    }

    @Override
    public boolean registerPlayer(String playerId, String playerName) {
        return true;
    }

    @Override
    public String getPlayer(String playerId) {
        if (playerId.equals("69420"))
            return "Frank";
        else
            return null;
    }

    @Override
    public int checkAvailability(String data, String compareTo) {
        if (compareTo.equals("userId")) {
            if (data.equals("69420"))
                return 1;
            else
                return 0;
        } else if (compareTo.equals("username")){
            if (data.equals("Frank"))
                return 1;
            else
                return 0;
        }
        else
            return -1;
    }
}

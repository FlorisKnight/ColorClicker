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
        return "Frank";
    }

    @Override
    public int checkIdAvailability(String playerId) {
        return 0;
    }

    @Override
    public int checkNameAvailability(String name) {
        return 0;
    }
}

package colorclickerrestserver;

import models.Score;

import java.util.List;

public interface IColorClickerRestDB {

    List<Score> getHighscores();

    boolean setHighscores(String playerName, int score, String gametype);

    boolean registerPlayer(String playerId, String playerName);

    String getPlayer(String playerId);

    int checkAvailability(String data, String compareTo);

}

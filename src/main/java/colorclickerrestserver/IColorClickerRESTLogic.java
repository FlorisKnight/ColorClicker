package colorclickerrestserver;

import models.Score;

import java.util.List;

public interface IColorClickerRESTLogic {

    boolean SignIn(String facebookId);

    boolean SignUp(String facebookId, String name);

    List<Score> getHighscores();

    boolean saveScores(String username, int score, String gameType);

    String getPlayer(String playerID);

}
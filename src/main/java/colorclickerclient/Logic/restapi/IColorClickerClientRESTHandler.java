package colorclickerclient.Logic.restapi;

import models.Score;

import java.util.ArrayList;
import java.util.List;

public interface IColorClickerClientRESTHandler {
    boolean SignUp(String facebookId, String name);

    boolean SignIn(String facebookId);

    List<Score> getHighscores();
}

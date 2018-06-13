package ColorClickerClient.Logic.REST;

import Models.Score;

import java.util.ArrayList;

public interface IColorClickerClientRESTHandler {
    boolean SignUp(String facebookId, String name);
    boolean SignIn(String facebookId);
    ArrayList<Score> getHighscores();
}

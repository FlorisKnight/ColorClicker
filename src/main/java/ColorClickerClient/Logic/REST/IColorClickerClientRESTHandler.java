package ColorClickerClient.Logic.REST;

import java.util.ArrayList;

public interface IColorClickerClientRESTHandler {
    boolean SignUp(String facebookId, String name);
    boolean SignIn(String facebookId);
    String[][] getHighscores();
}

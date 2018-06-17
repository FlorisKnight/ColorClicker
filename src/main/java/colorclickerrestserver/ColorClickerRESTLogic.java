package colorclickerrestserver;

import models.Score;

import java.util.List;

public class ColorClickerRESTLogic implements IColorClickerRESTLogic{
    IColorClickerRestDB databaseConn;

    public ColorClickerRESTLogic(IColorClickerRestDB databaseConn) {
        this.databaseConn = databaseConn;
    }

    public boolean SignIn(String facebookId) {
        try {
            if (databaseConn.getPlayer(facebookId) != null)
                return true;
            else
                return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean SignUp(String facebookId, String name) {
        if (databaseConn.checkAvailability(facebookId, "userId") == 0 && databaseConn.checkAvailability(name, "username") == 0)
            return databaseConn.registerPlayer(facebookId, name);
        else
            return false;
    }

    public List<Score> getHighscores() {
        return databaseConn.getHighscores();
    }

    public boolean saveScores(String username, int score, String gameType) {
        return databaseConn.setHighscores(username, score, gameType);
    }

    public String getPlayer(String playerID) {
        return databaseConn.getPlayer(playerID);
    }

}
package ColorClickerRESTServer;

import Models.Score;

import java.util.ArrayList;

public class ColorClickerRESTLogic{
    ColorClickerRESTServerDB databaseConn;

    public ColorClickerRESTLogic(ColorClickerRESTServerDB databaseConn){
        this.databaseConn = databaseConn;
    }

    public boolean SignIn(String facebookId){
        try {
            if (databaseConn.getPlayer(facebookId) != null)
                return true;
            else
                return false;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean SignUp(String facebookId, String name){
        if (databaseConn.checkIdAvailability(facebookId) == 0 && databaseConn.checkNameAvailability(name) == 0)
            return databaseConn.registerPlayer(facebookId, name);
        else
            return false;
    }

    public ArrayList<Score> getHighscores(){
        return databaseConn.getHighscores();
    }

    public boolean saveScores(String username, int score, String gameType){
        return databaseConn.setHighscores(username,score,gameType);
    }

    public String getPlayer(String playerID){
        return databaseConn.getPlayer(playerID);
    }

}
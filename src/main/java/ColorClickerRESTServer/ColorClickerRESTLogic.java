package ColorClickerRESTServer;

import WebsocketModels.*;
import com.google.gson.Gson;

public class ColorClickerRESTLogic{
    ColorClickerRESTServerDB databaseConn;

    public ColorClickerRESTLogic(){
        databaseConn = new ColorClickerRESTServerDB();
    }

    public String SignIn(String facebookId){
        try {
            if (databaseConn.getPlayer(facebookId) != null)
                return "true";
            else
                return "false";
        } catch (Exception e){
            System.out.println(e);
            return "false";
        }
    }

    public String SignUp(SignUp object){
        if (databaseConn.checkIdAvailability(object.getFacebookId()) == 0 && databaseConn.checkNameAvailability(object.getName()) == 0)
            return String.valueOf(databaseConn.registerPlayer(object.getFacebookId(), object.getName()));
        else
            return "false";
    }

    public String getHighscores(){
        String[][] highscores = databaseConn.getHighscores();
        return packResponseToJson("getHighscores", new getHighscores(highscores));
    }

    public String saveScores(SaveScore object){
        databaseConn.setHighscores(object.getUsername(),object.getScore(),object.getGameType());
        return "true";
    }

    public String getPlayer(String playerID){
        return databaseConn.getPlayer(playerID);
    }

    private String packResponseToJson(String action, Object object){
        Gson gson = new Gson();
        return gson.toJson(new jsonMessage(action, object));
    }
}
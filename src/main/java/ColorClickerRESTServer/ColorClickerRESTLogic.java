package ColorClickerRESTServer;

import WebsocketModels.*;
import com.google.gson.Gson;

public class ColorClickerRESTLogic{
    private ColorClickerRESTServerDB databaseConn;

    public ColorClickerRESTLogic(){
        databaseConn = new ColorClickerRESTServerDB();
    }

    public String SignIn(SignIn object){
        int playerId = 0;
        //TODO authentication and stuff and check for account
        return String.valueOf(playerId);
    }

    public String SignUp(SignUp object){
        int playerId = 0;
        //TODO authentication and stuff and check for account
        databaseConn.registerPlayer(playerId,object.getName());
        return String.valueOf(playerId);
    }

    public String getHighscores(){
        String[][] highscores = databaseConn.getHighscores();
        return packResponseToJson("getHighscores", new getHighscores(highscores));
    }

    public String saveScores(SaveScore object){
        databaseConn.setHighscores(object.getUsername(),object.getScore(),object.getGameType());
        return "true";
    }

    private String packResponseToJson(String action, Object object){
        Gson gson = new Gson();
        return gson.toJson(new jsonMessage(action, object));

    }
}
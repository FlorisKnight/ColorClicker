package ColorClickerRESTServer;

import ColorClickerRESTServer.OAuth.Facebook;
import Models.Player;
import WebsocketModels.*;
import com.google.gson.Gson;

public class ColorClickerRESTLogic{
    ColorClickerRESTServerDB databaseConn;
    Facebook oAuth;

    public ColorClickerRESTLogic(){
        databaseConn = new ColorClickerRESTServerDB();
        oAuth = new Facebook();
    }

    public String SignIn(SignIn object){
        int playerId = 0;
        try {
            playerId = oAuth.authUser();
        } catch (Exception e){
            System.out.println(e);
        }
        return String.valueOf(playerId);
    }

    public String SignUp(SignUp object){
        int playerId = 0;
        try {
            playerId = oAuth.authUser();
            databaseConn.registerPlayer(playerId,object.getName());
        } catch (Exception e){
            System.out.println(e);
        }
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

    public String getPlayer(int playerID){
        return databaseConn.getPlayer(playerID);
    }

    private String packResponseToJson(String action, Object object){
        Gson gson = new Gson();
        return gson.toJson(new jsonMessage(action, object));
    }
}
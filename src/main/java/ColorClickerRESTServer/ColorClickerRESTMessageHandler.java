package ColorClickerRESTServer;

import WebsocketModels.*;
import com.google.gson.Gson;

public class ColorClickerRESTMessageHandler implements IColorClickerRESTMessageHandler{
    private ColorClickerRESTLogic logic;
    public ColorClickerRESTMessageHandler(){
        logic = new ColorClickerRESTLogic();
    }

    public String MessageReader(String msg){
        Gson gson = new Gson();
        jsonMessage messageObject = gson.fromJson(msg, jsonMessage.class);

        switch (messageObject.getMessage()) {
            case "SignUp": return logic.SignUp((SignUp)messageObject.getObject());
            case "SignIn": return logic.SignIn((String)messageObject.getObject());
            case "GetHighscores": return logic.getHighscores();
            case "SetHighscore": return logic.saveScores((SaveScore)messageObject.getObject());
            case "GetPlayer": return logic.getPlayer((String)messageObject.getObject());
        }
        return null;
    }
}
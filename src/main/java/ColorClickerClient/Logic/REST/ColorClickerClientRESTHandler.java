package ColorClickerClient.Logic.REST;

import WebsocketModels.SignUp;
import WebsocketModels.getHighscores;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ColorClickerClientRESTHandler implements IColorClickerClientRESTHandler {
    ColorClickerClientRESTLogic rest;

    public ColorClickerClientRESTHandler(){
        rest = new ColorClickerClientRESTLogic();
    }

    @Override
    public boolean SignUp(String facebookId, String name) {
        SignUp data = new SignUp(facebookId, name);
        String result = rest.baseMethodPost(data, getQuery("SignUp"));

        return false;
    }

    @Override
    public boolean SignIn(String facebookId) {
        String result = rest.baseMethodPost(facebookId, getQuery("SignUp"));
        return false;
    }

    @Override
    public String[][] getHighscores() {
        String result = rest.baseMethodGet(getQuery("SignUp"));
        Gson gson = new Gson();
        if (result != null){
            getHighscores highscores = gson.fromJson(result, getHighscores.class);
            return highscores.getHighscores();
        } else
            return null;
    }

    private String getQuery(String path){
        String basicQuery = "http://localhost:8091/ColorClicker/";
        return basicQuery + path + "/";
    }
}

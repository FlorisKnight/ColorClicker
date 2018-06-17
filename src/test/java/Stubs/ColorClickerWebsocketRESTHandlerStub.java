package Stubs;

import colorclickerwebsocketserver.restapi.IColorClickerWebsocketRESTHandler;
import models.Score;

public class ColorClickerWebsocketRESTHandlerStub implements IColorClickerWebsocketRESTHandler{
    @Override
    public void setScore(Score score) {
    }

    @Override
    public String getPlayerName(String userId) {
        if (userId.equals("42069")){
            return "Burt";
        } else if (userId.equals("69420")){
            return "Frank";
        }
        return null;
    }
}

package colorclickerclient.Logic.restapi;

import colorclickerclient.Logic.restapi.dto.BoolResultDto;
import colorclickerclient.Logic.restapi.dto.HighscoresResultDto;
import colorclickerclient.Logic.restapi.dto.SignInRequestDto;
import colorclickerclient.Logic.restapi.dto.SignUpRequestDto;
import models.Score;

import java.util.ArrayList;
import java.util.List;

public class ColorClickerClientRESTHandler extends ColorClickerClientRESTBaseLogic implements IColorClickerClientRESTHandler {
    private final String url = "http://localhost:8091/ColorClicker/";

    @Override
    public boolean SignUp(String facebookId, String name) {
        SignUpRequestDto dto = new SignUpRequestDto(facebookId, name);
        BoolResultDto result = executeQueryPost(dto, getQuery("player/SignUp/"), BoolResultDto.class);
        return result.getCheck();
    }

    @Override
    public boolean SignIn(String facebookId) {
        SignInRequestDto dto = new SignInRequestDto(facebookId);
        BoolResultDto result = executeQueryPost(dto, getQuery("player/SignIn/"), BoolResultDto.class);
        return result.getCheck();
    }

    @Override
    public List<Score> getHighscores() {
        HighscoresResultDto result = executeQueryGet(getQuery("/Highscores/get/"), HighscoresResultDto.class);
        if (result.isSuccess()) {
            return result.getHighscores();
        } else
            return new ArrayList<Score>();
    }

    private String getQuery(String path) {
        return url + path;
    }
}

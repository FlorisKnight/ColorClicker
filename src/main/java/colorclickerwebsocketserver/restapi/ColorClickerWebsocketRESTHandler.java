package colorclickerwebsocketserver.restapi;

import colorclickerclient.Logic.restapi.ColorClickerClientRESTBaseLogic;
import colorclickerclient.Logic.restapi.dto.BoolResultDto;
import colorclickerwebsocketserver.restapi.dtowebsockets.GetPlayerRequestDto;
import colorclickerwebsocketserver.restapi.dtowebsockets.GetPlayerResultDto;
import colorclickerwebsocketserver.restapi.dtowebsockets.SetHighscoresPUTDto;
import models.Score;

public class ColorClickerWebsocketRESTHandler extends ColorClickerClientRESTBaseLogic implements IColorClickerWebsocketRESTHandler {
    private final String url = "http://localhost:8091/ColorClicker/";

    @Override
    public void setScore(Score score) {
        SetHighscoresPUTDto dto = new SetHighscoresPUTDto(score);
        executeQueryPost(dto, getQuery("/Highscores/put/"), BoolResultDto.class);
    }

    @Override
    public String getPlayerName(String userId) {
        GetPlayerRequestDto dto = new GetPlayerRequestDto(userId);
        GetPlayerResultDto result = executeQueryPost(dto, getQuery("/player/getPlayer/"), GetPlayerResultDto.class);
        return result.getName();
    }

    private String getQuery(String path) {
        return url + path;
    }
}

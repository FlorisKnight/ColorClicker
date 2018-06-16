package colorclickerclient.Logic.restapi;

import colorclickerclient.Logic.restapi.dto.BaseResultDto;
import colorclickerclient.Logic.restapi.dto.BoolResultDto;
import colorclickerclient.Logic.restapi.dto.HighscoresResultDto;
import colorclickerwebsocketserver.restapi.dtowebsockets.GetPlayerResultDto;
import com.google.gson.Gson;
import models.Score;

import java.util.List;

public class ResponseHelper {
    private ResponseHelper() {
    }

    private static final Gson gson = new Gson();

    public static String getErrorResponseString() {
        BaseResultDto response = new BaseResultDto();
        response.setSuccess(false);
        return gson.toJson(response);
    }

    public static String getBooleanResultDtoResponseString(boolean check) {
        BoolResultDto response = new BoolResultDto(check);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getHighscoresResultDtcString(List<Score> highscores) {
        HighscoresResultDto response = new HighscoresResultDto(highscores);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getGetPlayerResultDtcString(String name) {
        GetPlayerResultDto response = new GetPlayerResultDto(name);
        response.setSuccess(true);
        return gson.toJson(response);
    }
}

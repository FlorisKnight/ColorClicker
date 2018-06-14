package ColorClickerClient.Logic.REST;

import ColorClickerClient.Logic.REST.dto.BaseResultDto;
import ColorClickerClient.Logic.REST.dto.BoolResultDto;
import ColorClickerClient.Logic.REST.dto.HighscoresResultDto;
import ColorClickerWebsocketServer.REST.dtoWebsockets.GetPlayerResultDto;
import Models.Score;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ResponseHelper {
    private ResponseHelper(){}

    private static final Gson gson = new Gson();

    public static String getErrorResponseString()
    {
        BaseResultDto response = new BaseResultDto();
        response.setSuccess(false);
        return gson.toJson(response);
    }

    public static String getBooleanResultDtoResponseString(boolean check)
    {
        BoolResultDto response = new BoolResultDto(check);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getHighscoresResultDtcString(ArrayList<Score> highscores){
        HighscoresResultDto response = new HighscoresResultDto(highscores);
        response.setSuccess(true);
        return gson.toJson(response);
    }

    public static String getGetPlayerResultDtcString(String name){
        GetPlayerResultDto response = new GetPlayerResultDto(name);
        response.setSuccess(true);
        return gson.toJson(response);
    }
}

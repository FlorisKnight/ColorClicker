package ColorClickerWebsocketServer.REST;

import ColorClickerClient.Logic.REST.ColorClickerClientRESTBaseLogic;
import ColorClickerClient.Logic.REST.dto.BoolResultDto;
import ColorClickerClient.Logic.REST.dto.SignUpRequestDto;
import ColorClickerWebsocketServer.REST.dtoWebsockets.GetPlayerRequestDto;
import ColorClickerWebsocketServer.REST.dtoWebsockets.GetPlayerResultDto;
import ColorClickerWebsocketServer.REST.dtoWebsockets.SetHighscoresPUTDto;
import Models.Score;

public class ColorClickerWebsocketRESTHandler extends ColorClickerClientRESTBaseLogic implements IColorClickerWebsocketRESTHandler {
    private final String url = "http://localhost:8091/ColorClicker/";

    @Override
    public void setScore(Score score) {
        SetHighscoresPUTDto dto = new SetHighscoresPUTDto(score);
        executeQueryPut(dto, getQuery("/Highscores/put/"), BoolResultDto.class);
    }

    @Override
    public String getPlayerName(String userId) {
        GetPlayerRequestDto dto = new GetPlayerRequestDto(userId);
        GetPlayerResultDto result = executeQueryPost(dto, getQuery("/player/getPlayer"), GetPlayerResultDto.class);
        return result.getName();
    }

    private String getQuery(String path){
        return url + path;
    }
}

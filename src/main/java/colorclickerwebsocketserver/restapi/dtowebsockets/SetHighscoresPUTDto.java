package colorclickerwebsocketserver.restapi.dtowebsockets;

import colorclickerclient.Logic.restapi.dto.BaseRequestDto;
import models.Score;

public class SetHighscoresPUTDto extends BaseRequestDto {
    String name;
    int score;
    String gameType;


    public SetHighscoresPUTDto(Score score) {
        this.name = score.getName();
        this.score = score.getPoints();
        this.gameType = score.getGameType();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getGameType() {
        return gameType;
    }

}

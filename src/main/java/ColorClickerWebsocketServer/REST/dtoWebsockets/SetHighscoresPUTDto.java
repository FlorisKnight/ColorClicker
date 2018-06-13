package ColorClickerWebsocketServer.REST.dtoWebsockets;

import ColorClickerClient.Logic.REST.dto.BaseRequestDto;
import Models.Score;

public class SetHighscoresPUTDto extends BaseRequestDto {
    String name;
    int score;
    String gameType;


    public SetHighscoresPUTDto(Score score) {
        this.name = score.getName();
        this.score = score.getScore();
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

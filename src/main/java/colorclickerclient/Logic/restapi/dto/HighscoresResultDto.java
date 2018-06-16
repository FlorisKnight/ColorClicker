package colorclickerclient.Logic.restapi.dto;

import models.Score;

import java.util.List;

public class HighscoresResultDto extends BaseResultDto {
    List<Score> highscores;

    public HighscoresResultDto(List<Score> highscores) {
        this.highscores = highscores;
    }

    public List<Score> getHighscores() {
        return highscores;
    }
}

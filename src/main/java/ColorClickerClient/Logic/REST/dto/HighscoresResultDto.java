package ColorClickerClient.Logic.REST.dto;

import Models.Score;

import java.util.ArrayList;

public class HighscoresResultDto extends BaseResultDto {
    ArrayList<Score> highscores;

    public HighscoresResultDto(ArrayList<Score> highscores){
        this.highscores = highscores;
    }

    public ArrayList<Score> getHighscores(){
        return  highscores;
    }
}

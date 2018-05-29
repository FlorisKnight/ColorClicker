package WebsocketModels;

public class getHighscores {
    private String[][] highscores;

    public getHighscores(String[][] highscores){
        this.highscores = highscores;
    }

    public String[][] getHighscores(){
        return highscores;
    }
}

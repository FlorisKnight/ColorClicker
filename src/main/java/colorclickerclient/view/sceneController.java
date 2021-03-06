package colorclickerclient.view;

import colorclickerclient.Logic.ColorClickerClientLogic;
import models.Score;

import java.util.List;

public class sceneController {
    IColorClickerClientGUI application;
    ColorClickerClientLogic logic;
    sceneSignIn signIn;
    sceneSignUp signUp;
    sceneHome home;
    sceneHighscores highscores;
    sceneCreateGame createGame;
    sceneJoinGame joinGame;
    sceneGame game;

    public sceneController(IColorClickerClientGUI application) {
        logic = new ColorClickerClientLogic(this);
        this.application = application;
        signIn = new sceneSignIn(this, logic);
        signUp = new sceneSignUp(this, logic);
        home = new sceneHome(this, logic);
        createGame = new sceneCreateGame(this, logic);
        joinGame = new sceneJoinGame(this, logic);
    }

    public void signInScene() {
        application.Draw(signIn.getScene());
    }

    public void signUpScene() {
        application.Draw(signUp.getScene());
    }

    public void homeScene() {
        application.Draw(home.getScene());
    }

    public void createGameScene() {
        application.Draw(createGame.getScene());
    }

    public void joinGameScene() {
        application.Draw(joinGame.getScene());
    }

    public void highscores(List<Score> highscoresList) {
        highscores = new sceneHighscores(this, highscoresList);
        application.Draw(highscores.getScene());
    }

    public void game(sceneGame scene) {
        application.Draw(scene.getScene());
    }


}

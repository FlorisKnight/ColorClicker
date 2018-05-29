package ColorClickerClient.View;

import ColorClickerClient.Logic.ColorClickerClientLogic;
import javafx.scene.Scene;

public class sceneController {
    IColorClickerClientGUI application;
    ColorClickerClientLogic logic;
    sceneSignIn signIn;
    sceneSignUp signUp;
    sceneHome home;
    sceneHighscores highscores;
    sceneCreateGame createGame;
    sceneJoinGame joinGame;
    sceneGame game = new sceneGame(this);

    public sceneController(IColorClickerClientGUI application){
        this.application = application;
        signIn = new sceneSignIn(this);
        signUp = new sceneSignUp(this);
        home = new sceneHome(this);
        createGame = new sceneCreateGame(this);
        joinGame = new sceneJoinGame(this);
    }

    public void signInScene(){
        application.Draw(signIn.getScene());
    }

    public void signIn(String email, String password){
        if (true){
            application.Draw(home.getScene());
        }
    }

    public void signUpScene(){
        application.Draw(signIn.getScene());
    }

    public void signUp(String username, String email, String password){
        if (true){
            homeScene();
        }
    }

    public void homeScene(){
        application.Draw(home.getScene());
    }

    public void createGameScene(){
        application.Draw(createGame.getScene());
    }

    public void createGame(String gameType){

    }

    public void joinGameScene(){
        application.Draw(joinGame.getScene());
    }

    public void joinGame(String gameCode){

    }

    public void highscores(){
        highscores = new sceneHighscores(this,logic.GetHighscores());
    }

    public void game(){
        Scene scene = game.makeScene();
        application.Draw(scene);
        logic = new ColorClickerClientLogic(this, scene);
    }



}

package ColorClickerClient.Logic;

import ColorClickerClient.Logic.REST.ColorClickerClientRESTLogic;
import ColorClickerClient.Logic.Websockets.ColorClickerClientMessageCreator;
import ColorClickerClient.View.sceneController;
import ColorClickerClient.View.sceneGame;
import Models.Color;
import WebsocketModels.CreateGame;
import WebsocketModels.SignIn;
import WebsocketModels.SignUp;
import WebsocketModels.SquareClick;
import javafx.scene.Scene;

public class ColorClickerClientLogic {
    private ColorClickerClientMessageCreator messageCreator;
    private sceneGame game;
    private int userId;
    private sceneController controller;
    private ColorClickerClientRESTLogic REST;

    public ColorClickerClientLogic(sceneController controller, Scene scene){
        messageCreator = new ColorClickerClientMessageCreator();
        this.controller = controller;
        REST = new ColorClickerClientRESTLogic();
    }

    public void SignIn(String email, String password){
        //Rest
        userId = REST.SignIn(messageCreator.MessageCreator("SignIn", new SignIn(email,password)));
        if (userId != 0){
            controller.homeScene();
        }
    }

    public void SignUp(String email, String password, String name){
        userId = REST.SignIn(messageCreator.MessageCreator("SignUp", new SignUp(email,password, name)));
        //rest
        if (userId != 0){
            controller.homeScene();
        }
    }

    public void CreateGameSend(int gametype){
        messageCreator.MessageCreator("CreateGame", new CreateGame(gametype));
    }

    public void JoinGameSend(String gameCode){
        messageCreator.MessageCreator("JoinGame", gameCode);
    }

    public String[][] GetHighscores(){
        //Rest
        return new String[3][];
    }

    public void SquareClick(int xPos, int yPos){
        messageCreator.MessageCreator("SquareClick", new SquareClick(xPos, yPos));
    }

    public void EndGame(String playerName){
        game.showMessage(playerName + " has won!");
        controller.homeScene();
    }

    public void UpdateSquares(javafx.scene.paint.Color squareColor, int xPos, int yPos){
        game.UpdateSquares(squareColor, xPos, yPos);
    }

    public void SelectColor(Color squareColor){

    }
}
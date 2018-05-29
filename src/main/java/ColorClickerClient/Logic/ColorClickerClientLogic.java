package ColorClickerClient.Logic;

import ColorClickerClient.Logic.REST.ColorClickerClientRESTLogic;
import ColorClickerClient.Logic.Websockets.ColorClickerClientMessageCreator;
import ColorClickerClient.Logic.Websockets.ColorClickerClientMessageReader;
import ColorClickerClient.Logic.Websockets.ColorClickerEventClientSocket;
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
    private ColorClickerEventClientSocket clientSocket;
    private ColorClickerClientMessageReader handler;

    public ColorClickerClientLogic(sceneController controller, Scene scene){
        messageCreator = new ColorClickerClientMessageCreator();
        this.controller = controller;
        REST = new ColorClickerClientRESTLogic();
        handler = new ColorClickerClientMessageReader(this);
        clientSocket = new ColorClickerEventClientSocket(handler);
    }

    public void SignIn(String email, String password){
        userId = REST.SignIn(messageCreator.MessageCreator("SignIn", new SignIn(email,password)));
        if (userId != 0){
            controller.homeScene();
        }
    }

    public void SignUp(String email, String password, String name){
        userId = REST.SignIn(messageCreator.MessageCreator("SignUp", new SignUp(email,password, name)));

        if (userId != 0){
            controller.homeScene();
        }
    }

    public void CreateGameSend(int gametype){
        messageCreator.MessageCreator("CreateGame", new CreateGame(gametype));
    }

    public void CreateGameReceive(String gamecode, String playerName){
        //TODO make new game scene
    }

    public void JoinGameReceived(String gamecode, String player1Name, String player2Name){
        //TODO make new game scene
    }

    public void JoinGameSend(String gameCode){
        messageCreator.MessageCreator("JoinGame", gameCode);
    }

    public String[][] GetHighscores(){
        return REST.getHighscores();
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
}
package ColorClickerClient.Logic;

import ColorClickerClient.Logic.REST.ColorClickerClientRESTHandler;
import ColorClickerClient.Logic.Websockets.ColorClickerClientMessageCreator;
import ColorClickerClient.Logic.Websockets.ColorClickerClientMessageReader;
import ColorClickerClient.Logic.Websockets.ColorClickerEventClientSocket;
import ColorClickerClient.View.sceneController;
import ColorClickerClient.View.sceneGame;
import WebsocketModels.*;
import javafx.scene.Scene;
import ColorClickerClient.Logic.OAuth.*;

public class ColorClickerClientLogic implements IColorClickerClientCreateJoinGameLogic,IColorClickerClientGameLogic,IColorClickerClientHighscoreLogic,IColorClickerClientSignInSignUpLogic {
    private ColorClickerClientMessageCreator messageCreator;
    private sceneGame game;
    private String userId;
    private sceneController controller;
    private ColorClickerClientRESTHandler restHandler;
    private ColorClickerEventClientSocket clientSocket;
    private ColorClickerClientMessageReader handler;
    private FacebookOAuth oAuth;

    public ColorClickerClientLogic(sceneController controller, Scene scene){
        this.controller = controller;
        restHandler = new ColorClickerClientRESTHandler();
        handler = new ColorClickerClientMessageReader(this);
        clientSocket = new ColorClickerEventClientSocket(handler);
        messageCreator = new ColorClickerClientMessageCreator(clientSocket);
        oAuth = new FacebookOAuth();
    }

    //SignIn and SignUp logic

    public void SignIn(){
        String facebookId = null;
        try{
            facebookId = oAuth.authUser();
        }catch (Exception e){
            System.out.println(e);
        }
        if (facebookId != null && restHandler.SignIn(facebookId)){
            userId = facebookId;
            controller.homeScene();
        }
    }

    public void SignUp(String name){
        String facebookId = null;
        try{
            facebookId = oAuth.authUser();
        }catch (Exception e){
            System.out.println(e);
        }
        if (facebookId != null && name != null && restHandler.SignUp(facebookId, name)){
            userId = facebookId;
            controller.homeScene();
        }
    }

    //Creating a game

    public void CreateGameSend(String gametype){
        messageCreator.MessageCreator("CreateGame", new CreateGame(gametype, userId));
    }

    public void CreateGameReceive(CreateGameReceive object){
        int gameID = object.getGameID();
        String playerName = object.getPlayerName();

        game = new sceneGame(this, gameID, playerName);
        controller.game(game);
    }

    //Joining a game

    public void JoinGameSend(String gameIDTXT){
        try{
            int gameID = Integer.valueOf(gameIDTXT);
            messageCreator.MessageCreator("JoinGame", new JoinGame(gameID, userId));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void JoinGameReceived(JoinGameReceive object){
        int gameID = object.getGameID();
        String player1Name = object.getPlayer1Name();
        String player2Name = object.getPlayer2Name();

        game = new sceneGame(this, gameID, player1Name, player2Name);
    }

    //Getting Highscores
//TODO use algorithm to sort highscores

    public void GetHighscores(){
        controller.highscores(restHandler.getHighscores());
    }

    //Game Logic

    public void EndGame(String playerName){
        game.showMessage(playerName + " has won!");
        controller.homeScene();
    }

    public void SquareClick(int xPos, int yPos){
        messageCreator.MessageCreator("SquareClick", new SquareClick(xPos, yPos));
    }

    public void UpdateSquares(UpdateSquare object){
        javafx.scene.paint.Color squareColor = object.getColor();
        int xPos = object.getxPos();
        int yPos = object.getyPos();

        game.UpdateSquares(squareColor, xPos, yPos);
    }

    public void UpdatePlayerScore(UpdatePlayerScore object){
        int playerNr = object.getPlayer();
        int score = object.getScore();

        game.UpdatePlayerScore(playerNr, score);
    }

    public void UpdatePlayerName(String playerName){
        game.UpdatePlayerName(playerName);
    }

    public void UpdateTime(int time){
        game.UpdateTime(time);
    }
}
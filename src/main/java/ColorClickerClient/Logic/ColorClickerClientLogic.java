package ColorClickerClient.Logic;

import ColorClickerClient.Logic.REST.ColorClickerClientRESTHandler;
import ColorClickerClient.Logic.REST.IColorClickerClientRESTHandler;
import ColorClickerClient.Logic.REST.ResponseHelper;
import ColorClickerClient.Logic.Websockets.*;
import ColorClickerClient.Logic.Websockets.MessageModels.CreateGame;
import ColorClickerClient.Logic.Websockets.MessageModels.JoinGame;
import ColorClickerClient.Logic.Websockets.MessageModels.SquareClick;
import ColorClickerClient.View.sceneController;
import ColorClickerClient.View.sceneGame;
import ColorClickerClient.Logic.Websockets.IColorClickerMessageProcessor;
import ColorClickerClient.Logic.OAuth.*;
import javafx.scene.paint.Color;

public class ColorClickerClientLogic implements IColorClickerClientCreateJoinGameLogic,IColorClickerClientGameLogic,IColorClickerClientHighscoreLogic,IColorClickerClientSignInSignUpLogic {
    IColorClickerClientWebsocketMessageCreator messageCreator;
    sceneGame game;
    String userId;
    sceneController controller;
    IColorClickerClientRESTHandler restHandler;
    FacebookOAuth oAuth;

    public ColorClickerClientLogic(sceneController controller){
        this.controller = controller;
        restHandler = new ColorClickerClientRESTHandler();
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
            websocketConnect();
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
            websocketConnect();
            controller.homeScene();
        }
    }

    //Creating a game

    public void CreateGameSend(String gametype){
        messageCreator.MessageCreator("CreateGame", MessageModelHelper.getCreateGameString(gametype, userId));
    }

    public void CreateGameReceive(int gameId, String player){
        game = new sceneGame(this, gameId, player);
        controller.game(game);
    }

    //Joining a game

    public void JoinGameSend(String gameIDTXT){
        try{
            int gameID = Integer.valueOf(gameIDTXT);
            messageCreator.MessageCreator("JoinGame", MessageModelHelper.getJoinGameString(gameID, userId));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void JoinGameReceived(int gameId, String player1Name, String player2Name){
        game = new sceneGame(this, gameId, player1Name, player2Name);
        controller.game(game);
    }

    //Getting Highscores
//TODO use algorithm to sort highscores

    public void GetHighscores(){
        controller.highscores(restHandler.getHighscores());
    }

    //ColorClickerWebsocketGameLogic Logic

    public void EndGame(String playerName){
        game.showMessage(playerName + " has won!");
        controller.homeScene();
    }

    public void SquareClick(int xPos, int yPos){
        messageCreator.MessageCreator("SquareClick", MessageModelHelper.getSquareClickString(xPos, yPos));
    }

    public void UpdateSquares(int xPos, int yPos, Color color){
        game.UpdateSquares(color, xPos, yPos);
    }

    public void UpdatePlayerScore(int player, int score){
        game.UpdatePlayerScore(player, score);
    }

    public void UpdatePlayerName(String playerName){
        game.UpdatePlayerName(playerName);
    }

    public void UpdateTime(int time){
        game.UpdateTime(time);
    }

    private void websocketConnect(){
        IColorClickerMessageProcessor messageProcessor = new ColorClickerClientMessageProcessor(this);
        IColorClickerEventClientSocket clientSocket = new ColorClickerEventClientSocket(messageProcessor);
        messageCreator = new ColorClickerClientMessageCreator(clientSocket);
    }
}
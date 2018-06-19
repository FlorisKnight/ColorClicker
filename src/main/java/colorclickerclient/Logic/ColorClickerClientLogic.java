package colorclickerclient.Logic;

import colorclickerclient.Logic.oauth.FacebookOAuth;
import colorclickerclient.Logic.restapi.ColorClickerClientRESTHandler;
import colorclickerclient.Logic.restapi.IColorClickerClientRESTHandler;
import colorclickerclient.Logic.websockets.*;
import colorclickerclient.view.sceneController;
import colorclickerclient.view.sceneGame;
import javafx.scene.paint.Color;
import models.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ColorClickerClientLogic implements IColorClickerClientCreateJoinGameLogic, IColorClickerClientGameLogic, IColorClickerClientHighscoreLogic, IColorClickerClientSignInSignUpLogic {
    IColorClickerClientWebsocketMessageCreator messageCreator;
    sceneGame game;
    String userId;
    sceneController controller;
    IColorClickerClientRESTHandler restHandler;
    FacebookOAuth oAuth;
    String regex = "^[a-zA-Z0-9_-]*$";

    public ColorClickerClientLogic(sceneController controller) {
        this.controller = controller;
        restHandler = new ColorClickerClientRESTHandler();
        oAuth = new FacebookOAuth();
    }

    //SignIn and SignUp logic

    public void SignIn() {
        String facebookId = null;
        try {
            facebookId = oAuth.authUser();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (facebookId != null && restHandler.SignIn(facebookId)) {
            userId = facebookId;
            websocketConnect();
            controller.homeScene();
        }
    }

    public void SignUp(String name) {
        if (name.length() >= 4 && Pattern.matches(regex, name)) {
            String facebookId = null;
            try {
                facebookId = oAuth.authUser();
            } catch (Exception e) {
                System.out.println(e);
            }
            if (facebookId != null && name != null && restHandler.SignUp(facebookId, name)) {
                userId = facebookId;
                websocketConnect();
                controller.homeScene();
            }
        }
    }

    //Creating a game

    public void CreateGameSend(String gametype) {
        messageCreator.MessageCreator("CreateGame", MessageModelHelper.getCreateGameString(gametype, userId));
    }

    public void CreateGameReceive(int gameId, String player) {
        game = new sceneGame(this, gameId, player);
        controller.game(game);
    }

    //Joining a game

    public void JoinGameSend(String gameIDTXT) {
        try {
            int gameID = Integer.parseInt(gameIDTXT);
            messageCreator.MessageCreator("JoinGame", MessageModelHelper.getJoinGameString(gameID, userId));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void JoinGameReceived(int gameId, String player1Name, String player2Name) {
        game = new sceneGame(this, gameId, player1Name, player2Name);
        controller.game(game);
    }

    //Getting Highscores
    public void GetHighscores() {
        List<Score> highscores = restHandler.getHighscores();
        if (highscores.size() > 0)
            doInsertionSort(highscores);
        controller.highscores(highscores);
    }

    //ColorClickerWebsocketGameLogic Logic

    public void EndGame(String playerName) {
        game.showMessage(playerName + " has won!");
        controller.homeScene();
    }

    public void SquareClick(int xPos, int yPos) {
        messageCreator.MessageCreator("SquareClick", MessageModelHelper.getSquareClickString(xPos, yPos));
    }

    public void UpdateSquares(int xPos, int yPos, Color color) {
        game.UpdateSquares(color, xPos, yPos);
    }

    public void UpdatePlayerScore(int player, int score) {
        game.UpdatePlayerScore(player, score);
    }

    public void UpdatePlayerName(String playerName) {
        game.UpdatePlayerName(playerName);
    }

    private void websocketConnect() {
        IColorClickerMessageProcessor messageProcessor = new ColorClickerClientMessageProcessor(this);
        IColorClickerEventClientSocket clientSocket = new ColorClickerEventClientSocket(messageProcessor);
        messageCreator = new ColorClickerClientMessageCreator(clientSocket);
    }

    private List<Score> doInsertionSort(List<Score> input) {

        Score temp;
        for (int i = 1; i < input.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (input.get(j).getPoints() < input.get(j - 1).getPoints()) {
                    temp = input.get(j);
                    input.set(j, input.get(j - 1));
                    input.set(j - 1, temp);
                }
            }
        }
        return input;
    }
}
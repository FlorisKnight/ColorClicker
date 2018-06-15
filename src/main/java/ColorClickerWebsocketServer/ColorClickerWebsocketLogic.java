package ColorClickerWebsocketServer;

import ColorClickerWebsocketServer.REST.ColorClickerWebsocketRESTHandler;
import Models.Player;
import Models.Score;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ColorClickerWebsocketLogic implements IColorClickerWebsocketLogic{
    int gameId;
    ColorClickerWebsocketRESTHandler REST;
    ColorClickerWebsocketMessageCreator messageCreator;
    ColorClickerEventServerSocket eventSockets;
    ArrayList<ColorClickerWebsocketGameLogic> games;

    public ColorClickerWebsocketLogic(){
        REST = new ColorClickerWebsocketRESTHandler();
        gameId = 0;
        games = new ArrayList<>();
    }

    public void setEventSockets(ColorClickerEventServerSocket eventSockets) {
        this.eventSockets = eventSockets;
        messageCreator = new ColorClickerWebsocketMessageCreator(eventSockets);
    }

    public void CreateGame(String gametype, String userId, String sessionId){
        ColorClickerWebsocketGameLogic game = new ColorClickerWebsocketGameLogic(gameId++, CreatePlayer(userId, sessionId, Color.RED), this, gametype);
        games.add(game);
        messageCreator.MessageCreator("CreateGameReceive", MessageModelHelperServer.getCreateGameRevieveString(game.getGameId(), game.getPlayer1Name()), sessionId);
    }

    public void JoinGame(int gameId, String userId, String sessionId){
        for (ColorClickerWebsocketGameLogic g: games){
            if (gameId == g.getGameId() && g.checkAvailability()){
               g.AddPlayer(CreatePlayer(userId, sessionId, Color.BLUE));
               messageCreator.MessageCreator("JoinGameReceive", MessageModelHelperServer.getJoinGameReceiveString(g.getGameId(),g.getPlayer1Name(),g.getPlayer2Name()), sessionId);
               messageCreator.MessageCreator("UpdatePlayer", MessageModelHelperServer.getUpdatePlayerNameString(g.getPlayer2Name()), g.getPlayer1SessionID());
               g.StartGame();
            }
        }
    }

    public void EndGameMessage(String sessionID, String winner){
        messageCreator.MessageCreator("EndGameMessage", MessageModelHelperServer.getEndGameString(winner), sessionID);
    }

    public void UpdateSquares(javafx.scene.paint.Color squareColor, int xPos, int yPos, String sessionID){
        messageCreator.MessageCreator("UpdateSquares", MessageModelHelperServer.getUpdateSquareString(xPos,yPos, squareColor), sessionID);
    }

    public ColorClickerWebsocketGameLogic getGame(String sessionID){
        for (ColorClickerWebsocketGameLogic g: games){
            if(g.checkSessionID(sessionID)){
                return g;
            }
        }
        return null;
    }

    private Player CreatePlayer(String playerID, String sessionID, javafx.scene.paint.Color color){
        String name = REST.getPlayerName(playerID);
        return new Player(sessionID, playerID, name, color);
    }

    public void RemoveGame(ColorClickerWebsocketGameLogic game){
        games.remove(game);
    }

    public void UploadScores(String name, int score, String gameType) {
        REST.setScore(new Score(name, score, gameType));
    }
}
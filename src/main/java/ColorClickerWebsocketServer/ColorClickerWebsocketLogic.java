package ColorClickerWebsocketServer;

import ColorClickerClient.Logic.Websockets.ColorClickerClientMessageCreator;
import ColorClickerWebsocketServer.REST.ColorClickerWebsocketRESTLogic;
import Models.Color;
import Models.Game;
import Models.Player;
import WebsocketModels.*;
import sun.misc.ClassFileTransformer;

import java.util.ArrayList;

public class ColorClickerWebsocketLogic implements IColorClickerWebsocketLogic{
    int gameId;
    ColorClickerWebsocketRESTLogic REST;
    ColorClickerWebsocketMessageCreator messageCreator;
    ColorClickerEventServerSocket eventSockets;
    ArrayList<Game> games;

    public ColorClickerWebsocketLogic(ColorClickerEventServerSocket eventSockets){
        REST = new ColorClickerWebsocketRESTLogic(new ColorClickerWebsocketMessageReader(this));
        eventSockets = new ColorClickerEventServerSocket(this, new ColorClickerWebsocketMessageReader(this));
        this.eventSockets = eventSockets;
        messageCreator = new ColorClickerWebsocketMessageCreator(eventSockets);
        gameId = 0;
        games = new ArrayList<>();
    }

    public void CreateGame(CreateGame object, String sessionID){
        Game game = new Game(gameId++, CreatePlayer(object.getUserId(), sessionID, new javafx.scene.paint.Color(1,0,0,0)), this, object.getGametype());
        messageCreator.MessageCreator("CreateGameReceive", new CreateGameReceive(game.getGameId(), game.getPlayer1Name()), sessionID);
    }

    public void JoinGame(JoinGame object, String sessionID){
        for (Game g: games){
            if (object.getGameID() == g.getGameId()){
               g.AddPlayer(CreatePlayer(object.getUserId(), sessionID, javafx.scene.paint.Color.color(0,0,1,0)));
               messageCreator.MessageCreator("JoinGameRecieve", new JoinGameReceive(g.getGameId(),g.getPlayer1Name(),g.getPlayer2Name()), sessionID);
               messageCreator.MessageCreator("UpdatePlayer", g.getPlayer2Name(), g.getPlayer1SessionID());
            }
        }
    }

    public void SquareClick(SquareClick object, String sessionID){
        Game game = getGame(sessionID);
        if (game != null){
            game.SquareClick(sessionID, object.getxPos(), object.getyPos());
        }
    }

    public void EndGame(String sessionID, String winner){
        messageCreator.MessageCreator("EndGame", winner, sessionID);
    }

    public void UpdateSquares(javafx.scene.paint.Color squareColor, int xPos, int yPos, String sessionID){
        messageCreator.MessageCreator("UpdateSquares", new UpdateSquare(xPos,yPos, squareColor), sessionID);
    }

    private Game getGame(String sessionID){
        for (Game g: games){
            if(g.checkSessionID(sessionID)){
                return g;
            }
        }
        return null;
    }

    private Player CreatePlayer(int playerID, String sessionID, javafx.scene.paint.Color color){
        String name = REST.getPlayerName(playerID);
        return new Player(sessionID, playerID, name, color);
    }

    public void RemoveGame(Game game){
        games.remove(game);
    }
}
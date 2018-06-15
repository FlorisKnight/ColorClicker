package ColorClickerWebsocketServer;

import ColorClickerWebsocketServer.MessageModels.*;
import com.google.gson.Gson;
import javafx.scene.paint.Color;

public class MessageModelHelperServer {
    private static final Gson gson = new Gson();

    public static String getCreateGameRevieveString(int gameId, String playerName)
    {
        CreateGameReceive response = new CreateGameReceive(gameId, playerName);
        return gson.toJson(response);
    }

    public static String getEndGameString(String name)
    {
        EndGame response = new EndGame(name);
        return gson.toJson(response);
    }

    public static String getJoinGameReceiveString(int gameId, String player1Name, String player2Name)
    {
        JoinGameReceive response = new JoinGameReceive(gameId, player1Name, player2Name);
        return gson.toJson(response);
    }

    public static String getUpdatePlayerNameString(String player)
    {
        UpdatePlayerName response = new UpdatePlayerName(player);
        return gson.toJson(response);
    }

    public static String getUpdatePlayerScoreString(int player, int score)
    {
        UpdatePlayerScore response = new UpdatePlayerScore(player, score);
        return gson.toJson(response);
    }

    public static String getUpdateSquareString(int xPos, int yPos, Color color)
    {
        UpdateSquare response = new UpdateSquare(xPos,yPos,color);
        return gson.toJson(response);
    }


}

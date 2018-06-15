package ColorClickerClient.Logic.Websockets;

import ColorClickerClient.Logic.REST.dto.BoolResultDto;
import ColorClickerClient.Logic.Websockets.MessageModels.CreateGame;
import ColorClickerClient.Logic.Websockets.MessageModels.JoinGame;
import ColorClickerClient.Logic.Websockets.MessageModels.SquareClick;
import com.google.gson.Gson;

public class MessageModelHelper {

    private static final Gson gson = new Gson();

    public static String getCreateGameString(String gametype, String userId)
    {
        CreateGame response = new CreateGame(gametype, userId);
        return gson.toJson(response);
    }

    public static String getJoinGameString(int gameId, String userId)
    {
        JoinGame response = new JoinGame(gameId, userId);
        return gson.toJson(response);
    }

    public static String getSquareClickString(int xPos, int yPos)
    {
        SquareClick response = new SquareClick(xPos, yPos);
        return gson.toJson(response);
    }


}

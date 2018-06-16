package colorclickerclient.Logic.websockets;

import colorclickerclient.Logic.websockets.messagemodels.CreateGame;
import colorclickerclient.Logic.websockets.messagemodels.JoinGame;
import colorclickerclient.Logic.websockets.messagemodels.SquareClick;
import com.google.gson.Gson;

public class MessageModelHelper {

    private static final Gson gson = new Gson();

    private MessageModelHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static String getCreateGameString(String gametype, String userId) {
        CreateGame response = new CreateGame(gametype, userId);
        return gson.toJson(response);
    }

    public static String getJoinGameString(int gameId, String userId) {
        JoinGame response = new JoinGame(gameId, userId);
        return gson.toJson(response);
    }

    public static String getSquareClickString(int xPos, int yPos) {
        SquareClick response = new SquareClick(xPos, yPos);
        return gson.toJson(response);
    }


}

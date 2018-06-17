package colorclickerclient.Logic.websockets;

import colorclickerclient.Logic.websockets.messagemodels.CreateGame;
import colorclickerclient.Logic.websockets.messagemodels.JoinGame;
import colorclickerclient.Logic.websockets.messagemodels.SquareClick;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageModelHelperTest {
    Gson gson = new Gson();

    @Test
    public void getCreateGameString() {
        String actual = MessageModelHelper.getCreateGameString("Fast","69420");
        String expected = gson.toJson(new CreateGame("Fast", "69420"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getJoinGameString() {
        String actual = MessageModelHelper.getJoinGameString(0,"69420");
        String expected = gson.toJson(new JoinGame(0, "69420"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSquareClickString() {
        String actual = MessageModelHelper.getSquareClickString(0,0);
        String expected = gson.toJson(new SquareClick(0,0));
        Assert.assertEquals(expected, actual);
    }
}
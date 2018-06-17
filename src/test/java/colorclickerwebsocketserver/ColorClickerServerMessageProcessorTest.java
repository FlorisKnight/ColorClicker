package colorclickerwebsocketserver;

import Stubs.ColorClickerWebsocketGameLogicStub;
import Stubs.ColorClickerWebsocketLogicStub;
import colorclickerclient.Logic.websockets.messagemodels.CreateGame;
import colorclickerclient.Logic.websockets.messagemodels.JoinGame;
import colorclickerclient.Logic.websockets.messagemodels.SquareClick;
import colorclickerwebsocketserver.messagemodels.CreateGameReceive;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import shared.jsonMessage;

import static org.junit.Assert.*;

public class ColorClickerServerMessageProcessorTest {
    ColorClickerWebsocketLogicStub logic = new ColorClickerWebsocketLogicStub();
    IColorClickerWebsocketServerMessageProcessor messageProcessor = new ColorClickerServerMessageProcessor(logic);
    Gson gson = new Gson();

    @Test
    public void processMessageCreateGame() {
        String object = gson.toJson(new CreateGame("Fast", "69420"));
        String message = gson.toJson(new jsonMessage("CreateGame",object));

        messageProcessor.processMessage(message, "session1");
        Assert.assertEquals("Fast", logic.getGametype());
        Assert.assertEquals("69420", logic.getUserId());
    }

    @Test
    public void processMessageJoinGame() {
        String object = gson.toJson(new JoinGame(0, "42069"));
        String message = gson.toJson(new jsonMessage("JoinGame",object));

        messageProcessor.processMessage(message, "session2");
        Assert.assertEquals(0, logic.getGameId());
        Assert.assertEquals("42069", logic.getUserId());
    }

    @Test
    public void processMessageSquareClick() {
        String object = gson.toJson(new SquareClick(0, 0));
        String message = gson.toJson(new jsonMessage("SquareClick",object));

        messageProcessor.processMessage(message, "session1");
        ColorClickerWebsocketGameLogicStub game = logic.getGame();

        Assert.assertEquals(0, game.getxPos());
        Assert.assertEquals(0, game.getyPos());
    }

}
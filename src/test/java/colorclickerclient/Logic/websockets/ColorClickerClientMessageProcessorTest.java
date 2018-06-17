package colorclickerclient.Logic.websockets;

import Stubs.ColorClickerClientLogicStub;
import Stubs.ColorClickerWebsocketLogicStub;
import colorclickerwebsocketserver.messagemodels.*;
import com.google.gson.Gson;
import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.Test;
import shared.jsonMessage;

import static org.junit.Assert.*;

public class ColorClickerClientMessageProcessorTest {
    ColorClickerClientLogicStub logic = new ColorClickerClientLogicStub();
    IColorClickerMessageProcessor messageProcessor = new ColorClickerClientMessageProcessor(logic);
    Gson gson = new Gson();

    @Test
    public void processMessageCreateGameReceive() {
        String object = gson.toJson(new CreateGameReceive(0, "Frank"));
        String message = gson.toJson(new jsonMessage("CreateGameReceive",object));

        messageProcessor.processMessage(message);
        Assert.assertEquals(0, logic.getGameId());
        Assert.assertEquals("Frank", logic.getPlayername());
    }

    @Test
    public void processMessageJoinGameReceive() {
        String object = gson.toJson(new JoinGameReceive(0, "Frank", "Burt"));
        String message = gson.toJson(new jsonMessage("JoinGameReceive",object));

        messageProcessor.processMessage(message);
        Assert.assertEquals(0, logic.getGameId());
        Assert.assertEquals("Frank", logic.getPlayer1Name());
        Assert.assertEquals("Burt", logic.getPlayer2Name());
    }

    @Test
    public void processMessageEndGameMessage() {
        String object = gson.toJson(new EndGame("Frank"));
        String message = gson.toJson(new jsonMessage("EndGameMessage",object));

        messageProcessor.processMessage(message);
        Assert.assertEquals("Frank", logic.getPlayername());
    }

    @Test
    public void processMessageUpdateSquares() {
        String object = gson.toJson(new UpdateSquare(0, 0, Color.RED));
        String message = gson.toJson(new jsonMessage("UpdateSquares",object));

        messageProcessor.processMessage(message);
        Assert.assertEquals(0, logic.getxPos());
        Assert.assertEquals(0, logic.getyPos());
        Assert.assertEquals(Color.RED, logic.getColor());
    }

    @Test
    public void processMessageUpdatePlayerScore() {
        String object = gson.toJson(new UpdatePlayerScore(0, 10));
        String message = gson.toJson(new jsonMessage("UpdatePlayerScore",object));

        messageProcessor.processMessage(message);
        Assert.assertEquals(0, logic.getPlayer());
        Assert.assertEquals(10, logic.getScore());
    }

    @Test
    public void processMessageUpdatePlayerName() {
        String object = gson.toJson(new UpdatePlayerName("Frank"));
        String message = gson.toJson(new jsonMessage("UpdatePlayerName",object));

        messageProcessor.processMessage(message);
        Assert.assertEquals(logic.getPlayername(), "Frank");
    }





}
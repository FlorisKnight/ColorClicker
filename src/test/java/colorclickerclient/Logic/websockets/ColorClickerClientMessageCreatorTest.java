package colorclickerclient.Logic.websockets;

import Stubs.ColorClickerEventClientSocketStub;
import colorclickerclient.Logic.websockets.messagemodels.CreateGame;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import shared.jsonMessage;

import static org.junit.Assert.*;

public class ColorClickerClientMessageCreatorTest {
    ColorClickerEventClientSocketStub socketStub = new ColorClickerEventClientSocketStub();
    IColorClickerClientWebsocketMessageCreator messageCreator = new ColorClickerClientMessageCreator(socketStub);
    @Test
    public void messageCreator() {
        Gson gson = new Gson();
        String object = gson.toJson(new CreateGame("Fast","42069"));
        messageCreator.MessageCreator("CreateGame", object);
        String actual = socketStub.getMessage();
        String objectExpected = gson.toJson(new CreateGame("Fast","42069"));
        String expected = gson.toJson(new jsonMessage("CreateGame", objectExpected));
        Assert.assertEquals(expected,actual);
    }
}
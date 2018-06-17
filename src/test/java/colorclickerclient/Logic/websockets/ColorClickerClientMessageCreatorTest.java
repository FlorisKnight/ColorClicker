package colorclickerclient.Logic.websockets;

import Stubs.ColorClickerEventClientSocketStub;
import colorclickerclient.Logic.websockets.messagemodels.CreateGame;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

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
        String expected = "{\"message\":\"CreateGame\",\"object\":\"{\\\"gametype\\\":\\\"Fast\\\",\\\"userId\\\":\\\"42069\\\"}\"}";
        Assert.assertEquals(expected,actual);
    }
}
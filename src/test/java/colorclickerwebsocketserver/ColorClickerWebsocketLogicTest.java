package colorclickerwebsocketserver;

import Stubs.ColorClickerEventServerSocketStub;
import Stubs.ColorClickerWebsocketRESTHandlerStub;
import colorclickerwebsocketserver.restapi.IColorClickerWebsocketRESTHandler;
import javafx.scene.paint.Color;
import models.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColorClickerWebsocketLogicTest {
    IColorClickerWebsocketRESTHandler rest = new ColorClickerWebsocketRESTHandlerStub();
    IColorClickerEventServerSocket socket = new ColorClickerEventServerSocketStub();
    IColorClickerWebsocketLogic logic = new ColorClickerWebsocketLogic(rest);

    Player player1 = new Player("session1", "42069", "Burt", Color.RED);
    IColorClickerWebsocketGameLogic gameStub = new ColorClickerWebsocketGameLogic(0, player1, logic, "Fast");

    @Before
    public void setEventSockets() {
        logic.setEventSockets(socket);
    }

    @Test
    public void createGame() {
        logic.CreateGame("Fast", "42069", "session1");
        IColorClickerWebsocketGameLogic game = logic.getGame("session1");
        Assert.assertTrue(game != null);
    }

    @Test
    public void joinGame() {
        logic.CreateGame("Fast", "42069", "session1");
        logic.JoinGame(0,"69420","session2");
        IColorClickerWebsocketGameLogic game = logic.getGame("session2");
        Assert.assertTrue(game != null);
    }

    @Test
    public void getGame() {
        logic.CreateGame("Fast", "42069", "session1");
        IColorClickerWebsocketGameLogic game = logic.getGame("session1");
        Assert.assertTrue(game != null);
    }

    @Test
    public void removeGame() {
        logic.CreateGame("Fast", "42069", "session1");
        logic.RemoveGame(logic.getGame("session1"));
        IColorClickerWebsocketGameLogic game = logic.getGame("session1");
        Assert.assertTrue(game == null);
    }
}
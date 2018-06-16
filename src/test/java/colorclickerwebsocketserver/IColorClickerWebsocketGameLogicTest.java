package colorclickerwebsocketserver;

import Stubs.ColorClickerWebsocketLogicStud;
import javafx.scene.paint.Color;
import models.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IColorClickerWebsocketGameLogicTest {
    Player player1 = new Player("69420","SessionId1", "Burt", Color.RED);
    Player player2 = new Player("42069","SessionId2", "Frank", Color.BLUE);
    IColorClickerWebsocketLogic logic = new ColorClickerWebsocketLogicStud();
    IColorClickerWebsocketGameLogic game = new ColorClickerWebsocketGameLogic(0,player1, logic, "Normal");


    @Test
    @Before
    public void addPlayer() {
        game.AddPlayer(player2);
        Assert.assertEquals( player2 ,game.getPlayer2());
    }

    @Test
    public void squareClick() {
        game.StartGame();
        game.SquareClick("42069", 0, 0);
        Player[][] field = game.getField();
        Assert.assertEquals(player2, field[0][0]);
    }

    @Test
    public void checkSessionID() {
        Assert.assertTrue(game.checkSessionID("42069"));
    }

    @Test
    public void getGameId() {
        Assert.assertEquals(0, game.getGameId());
    }

    @Test
    public void getPlayer1Name() {
        Assert.assertEquals("Burt", game.getPlayer1Name());
    }

    @Test
    public void getPlayer2Name() {
        Assert.assertEquals("Frank", game.getPlayer2Name());
    }

    @Test
    public void getPlayer1SessionID() {
        Assert.assertEquals("69420", game.getPlayer1SessionID());
    }

    @Test
    public void checkAvailability() {
        Assert.assertFalse(game.checkAvailability());
    }
}
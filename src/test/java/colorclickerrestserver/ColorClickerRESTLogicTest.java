package colorclickerrestserver;

import Stubs.ColorClickerRESTdbStub;
import models.Score;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ColorClickerRESTLogicTest {
    IColorClickerRestDB database = new ColorClickerRESTdbStub();
    IColorClickerRESTLogic logic = new ColorClickerRESTLogic(database);

    @Test
    public void signIn() {
        Assert.assertEquals(true,logic.SignIn("69420"));
    }

    @Test
    public void signUp() {
        Assert.assertEquals(true,logic.SignUp("69420", "Frank"));
    }

    @Test
    public void getHighscores() {
        Assert.assertEquals(new ArrayList<Score>(), logic.getHighscores());
    }

    @Test
    public void saveScores() {
        Assert.assertEquals(true,logic.saveScores("Frank", 420, "Normal"));
    }

    @Test
    public void getPlayer() {
        Assert.assertEquals("Frank", logic.getPlayer("69420"));
    }
}
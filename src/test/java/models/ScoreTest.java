package models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {
    Score score = new Score("Frank", 9000, "Fast");

    @Test
    public void getName() {
        String name = score.getName();
        Assert.assertEquals("Frank", name);
    }

    @Test
    public void getPoints() {
        int points = score.getPoints();
        Assert.assertEquals(9000, points);
    }

    @Test
    public void getGameType() {
        String gameType = score.getGameType();
        Assert.assertEquals("Fast", gameType);
    }
}
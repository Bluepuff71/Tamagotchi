package game.items.Toys;

import game.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BallTest {

    @Test
    public void interact() {
        Tamagotchi t = new Tamagotchi("Test");
        t.setWater(25);
        t.setMood(25);
        t.setCleanliness(25);
        t.setFood(25);
        new Ball().interact(t);
        Assert.assertEquals(15, t.getCleanliness());
        Assert.assertEquals(35, t.getMood());
    }
}
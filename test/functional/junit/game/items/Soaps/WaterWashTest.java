package game.items.Soaps;

import game.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WaterWashTest {

    @Test
    public void interact() {
        Tamagotchi t = new Tamagotchi("Test");
        t.setWater(25);
        t.setMood(25);
        t.setCleanliness(25);
        t.setFood(25);
        new WaterWash().interact(t);
        Assert.assertEquals(30, t.getCleanliness());
    }
}
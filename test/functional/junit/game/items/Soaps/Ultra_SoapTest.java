package game.items.Soaps;

import game.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ultra_SoapTest {

    @Test
    public void interact() {
        Tamagotchi t = new Tamagotchi("Test");
        t.setWater(25);
        t.setMood(25);
        t.setCleanliness(25);
        t.setFood(25);
        new Ultra_Soap().interact(t);
        Assert.assertEquals(40, t.getCleanliness());
    }
}
package game.items.Drinks;

import game.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SodaTest {

    @Test
    public void drink() {
        Tamagotchi t = new Tamagotchi("Test");
        t.setWater(25);
        t.setMood(25);
        new Soda().consume(t);
        Assert.assertEquals(35, t.getWater());
        Assert.assertEquals(45, t.getMood());
    }
}
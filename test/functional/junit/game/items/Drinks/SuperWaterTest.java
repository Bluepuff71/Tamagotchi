package game.items.Drinks;

import game.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuperWaterTest {

    @Test
    public void drink() {
        Tamagotchi t = new Tamagotchi("Test");
        t.setWater(25);
        t.setMood(25);
        new SuperWater().consume(t);
        Assert.assertEquals(45, t.getWater());
        Assert.assertEquals(35, t.getMood());
    }
}
package game.items.Drinks;

import game.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JuiceTest {

    @Test
    public void drink() {
        Tamagotchi t = new Tamagotchi("Test");
        t.setWater(20);
        t.setMood(20);
        new Juice().consume(t);
        Assert.assertEquals(35, t.getWater());
        Assert.assertEquals(35, t.getMood());
    }
}
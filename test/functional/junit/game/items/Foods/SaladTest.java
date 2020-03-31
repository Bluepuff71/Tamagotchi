package game.items.Foods;

import game.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaladTest {

    @Test
    public void eat() {
        Tamagotchi t = new Tamagotchi("Test");
        t.setWater(25);
        t.setMood(25);
        t.setCleanliness(25);
        t.setFood(25);
        new Salad().consume(t);
        Assert.assertEquals(20, t.getWater());
        Assert.assertEquals(35, t.getMood());
        Assert.assertEquals(45, t.getFood());
        Assert.assertEquals(15, t.getCleanliness());
    }
}
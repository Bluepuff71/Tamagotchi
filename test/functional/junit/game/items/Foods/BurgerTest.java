package game.items.Foods;

import game.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurgerTest {

    @Test
    public void eat() {
        Tamagotchi t = new Tamagotchi("Test");
        t.setWater(25);
        t.setMood(25);
        t.setCleanliness(25);
        t.setFood(25);
        new Burger().consume(t);
        Assert.assertEquals(20, t.getWater());
        Assert.assertEquals(40, t.getMood());
        Assert.assertEquals(35, t.getFood());
        Assert.assertEquals(15, t.getCleanliness());
    }
}
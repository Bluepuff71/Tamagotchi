package game;

import game.core.enums.MoodStates;
import game.core.enums.Personality;
import game.items.Foods.Burger;
import game.items.Toys.Ball;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TamagotchiTest {

    private Tamagotchi t;
    @Before
    public void setUp() throws Exception {
        t = new Tamagotchi("Test");
    }

    @Test
    public void decrementStats() {
        t.decrementStats();
        Assert.assertEquals(99, t.getWater());
        Assert.assertEquals(99, t.getMood());
        Assert.assertEquals(99, t.getFood());
        Assert.assertEquals(99, t.getCleanliness());
    }

    @Test
    public void getName() {
        Assert.assertEquals("Test", t.getName());
    }

    @Test
    public void setName() {
        t.setName("New Name");
        Assert.assertEquals("New Name", t.getName());
    }

    @Test
    public void getAndSetFood() {
        t.setFood(80);
        Assert.assertEquals(80, t.getFood());
    }

    @Test
    public void getAndSetWater() {
        t.setWater(80);
        Assert.assertEquals(80, t.getWater());
    }

    @Test
    public void getAndSetCleanliness() {
        t.setCleanliness(80);
        Assert.assertEquals(80, t.getCleanliness());
    }

    @Test
    public void getMoodState() {
        t.setMood(0);
        Assert.assertEquals(MoodStates.DEAD, t.getMoodState());
        t.setMood(15);
        Assert.assertEquals(MoodStates.SAD, t.getMoodState());
        t.setMood(45);
        Assert.assertEquals(MoodStates.NEUTRAL, t.getMoodState());
        t.setMood(90);
        Assert.assertEquals(MoodStates.HAPPY, t.getMoodState());
    }

    @Test
    public void getAndSetMood() {
        t.setMood(80);
        Assert.assertEquals(80, t.getMood());
    }

    @Test
    public void ToStringNotNull(){
        Assert.assertNotNull(t.toString());
    }

    @Test
    public void setPersonality() {
        t.setPersonality(Personality.NORMAL);
        Assert.assertEquals(Personality.NORMAL ,t.getPersonality());
    }

    @Test
    public void privateFuncClampXGreaterThanMax(){
        t.setWater(110);
        Assert.assertEquals(100, t.getWater());
    }

    @Test
    public void privateFuncClampXLessThanMin(){
        t.setWater(-5);
        Assert.assertEquals(0, t.getWater());
    }

    @Test
    public void getAndSetMoney(){
        t.setMoney(30);
        Assert.assertEquals(30, t.getMoney());
    }

    @Test
    public void getInventory(){
       Assert.assertNotNull(t.getInventory(Burger.class).get(0));
    }
}
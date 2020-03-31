package game.core.abstracts;

import game.items.Foods.Burger;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void getDescription() {
        Item item = new Burger();
        item.setDescription("Test");
        Assert.assertEquals("Test", item.getDescription());
    }

    @Test
    public void getCost() {
        Item item = new Burger();
        item.setCost(49);
        Assert.assertEquals(49, item.getCost());
    }
}
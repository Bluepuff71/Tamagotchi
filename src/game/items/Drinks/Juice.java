package game.items.Drinks;

import game.Tamagotchi;
import game.core.abstracts.Drink;

public final class Juice extends Drink {

    public Juice() {
        this.setCost(100);
        this.setDescription("Fresh squeezed juice!");
        this.setName("Juice");
    }

    @Override
    public void drink(Tamagotchi tamagotchi) {
        //increase mood after drinking drink
        tamagotchi.setMood(tamagotchi.getMood() + 15);
        //increase water value because drink was consumed
        tamagotchi.setWater(tamagotchi.getWater() + 15);
    }
    
}
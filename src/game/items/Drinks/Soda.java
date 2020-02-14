package game.items.Drinks;

import game.Tamagotchi;
import game.core.abstracts.Drink;

public final class Soda extends Drink {

    public Soda() {
        this.setCost(150);
        this.setDescription("Fizzy soda!");
        this.setName("Soda");
    }

    @Override
    public void drink(Tamagotchi tamagotchi) {
        //increase mood after drinking drink
        tamagotchi.setMood(tamagotchi.getMood() + 20);
        //decrease thirst beacause drink was consumed
        tamagotchi.setWater(tamagotchi.getWater() - 10);
    }
    
}
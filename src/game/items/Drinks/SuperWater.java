package game.items.Drinks;

import game.Tamagotchi;
import game.core.abstracts.Drink;

public final class SuperWater extends Drink {

    public SuperWater() {
        this.setCost(200);
        this.setDescription("Water with superior hydration!");
        this.setName("Super Water");
    }

    @Override
    public void drink(Tamagotchi tamagotchi) {
        //increase mood after drinking drink
        tamagotchi.setMood(tamagotchi.getMood() + 10);
        //increase water value because drink was consumed
        tamagotchi.setWater(tamagotchi.getWater() + 20);
    }
    
}
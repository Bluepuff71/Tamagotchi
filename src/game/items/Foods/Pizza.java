package game.items.Foods;

import game.Tamagotchi;
import game.core.abstracts.Food;

public final class Pizza extends Food {

    public Pizza() {
        this.setCost(100);
        this.setDescription("A slice of pizza!");
        this.setName("Pizza");
    }

    @Override
    public void eat(Tamagotchi tamagotchi) {
        //increase mood after eating food
        tamagotchi.setMood(tamagotchi.getMood() + 20);
        //decrease cleanliness after eating food
        tamagotchi.setCleanliness(tamagotchi.getCleanliness() - 10);
        //increase food value because food was consumed
        tamagotchi.setFood(tamagotchi.getFood() + 5);
        //decrease water value because food was consumed
        tamagotchi.setWater(tamagotchi.getWater() - 5);
    }
    
}
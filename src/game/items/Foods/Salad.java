package game.items.Foods;

import game.Tamagotchi;
import game.core.abstracts.Food;

public final class Salad extends Food {

    public Salad() {
        this.setCost(200);
        this.setDescription("A healthy salad!");
        this.setName("Salad");
    }

    @Override
    public void eat(Tamagotchi tamagotchi) {
        //increase mood after eating food
        tamagotchi.setMood(tamagotchi.getMood() + 10);
        //decrease cleanliness after eating food
        tamagotchi.setCleanliness(tamagotchi.getCleanliness() - 10);
        //increase food value because food was consumed
        tamagotchi.setFood(tamagotchi.getFood() + 20);
        //decrease water value because food was consumed
        tamagotchi.setWater(tamagotchi.getWater() - 5);
    }
    
}
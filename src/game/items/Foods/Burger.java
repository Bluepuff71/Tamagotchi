package game.items.Foods;

import game.Tamagotchi;
import game.core.abstracts.Food;

public final class Burger extends Food {

    public Burger() {
        this.setCost(150);
        this.setDescription("A delicious cheeseburger!");
        this.setName("Cheeseburger");
    }

    @Override
    public void eat(Tamagotchi tamagotchi) {
        //increase mood after eating food
        tamagotchi.setMood(tamagotchi.getMood() + 15);
        //decrease cleanliness after eating food
        tamagotchi.setCleanliness(tamagotchi.getCleanliness() - 10);
        //increase food value because food was consumed
        tamagotchi.setFood(tamagotchi.getFood() + 10);
        //decrease water value because food was consumed
        tamagotchi.setWater(tamagotchi.getWater() - 5);
    }
    
}
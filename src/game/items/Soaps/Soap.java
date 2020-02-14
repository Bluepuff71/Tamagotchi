package game.items.Soaps;

import game.Tamagotchi;
import game.core.abstracts.Cleanable;
import game.core.interfaces.IInteractable;

public final class Soap extends Cleanable {

    public Soap(){
        this.setCost(10);
        this.setName("Soap");
        this.setDescription("Standard Soap");
    }

    @Override
    public void interact(Tamagotchi tamagotchi) {
        int cleanliness = tamagotchi.getCleanliness();
        
        cleanliness += 10;

        tamagotchi.setCleanliness(cleanliness);
    }
        

}
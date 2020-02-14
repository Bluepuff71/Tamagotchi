package game.items.Soaps;

import game.Tamagotchi;
import game.core.abstracts.Cleanable;
import game.core.interfaces.IInteractable;

public final class Ultra_Soap extends Cleanable {

    public Ultra_Soap(){
        this.setCost(10);
        this.setName("Ultra Soap");
        this.setDescription("Some ultra soap");
    }

    @Override
    public void interact(Tamagotchi tamagotchi) {
        int cleanliness = tamagotchi.getCleanliness();

        cleanliness += 15;

        tamagotchi.setCleanliness(cleanliness);
    }


}
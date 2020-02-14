package game.items.Soaps;

import game.Tamagotchi;
import game.core.abstracts.Cleanable;
import game.core.interfaces.IInteractable;

public final class WaterWash extends Cleanable {

    public WaterWash(){
        this.setCost(10);
        this.setName("Water Wash");
        this.setDescription("A water wash");
    }

    @Override
    public void interact(Tamagotchi tamagotchi) {
        int cleanliness = tamagotchi.getCleanliness();
        
        cleanliness += 5;

        tamagotchi.setCleanliness(cleanliness);
    }
        

}
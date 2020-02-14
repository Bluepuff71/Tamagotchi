package game.wash_method;

import game.Tamagotchi;
import game.core.interfaces.IInteractable;

public class WaterWash implements IInteractable {

    @Override
    public void interact(Tamagotchi tamagotchi) {
        int cleanliness = tamagotchi.getCleanliness();
        
        cleanliness += 5;

        tamagotchi.setCleanliness(cleanliness);
    }
        

}
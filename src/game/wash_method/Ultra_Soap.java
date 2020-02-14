package game.wash_method;

import game.Tamagotchi;
import game.core.interfaces.IInteractable;

public class Ultra_Soap implements IInteractable {

    @Override
    public void interact(Tamagotchi tamagotchi) {
        int cleanliness = tamagotchi.getCleanliness();
        
        cleanliness += 15;

        tamagotchi.setCleanliness(cleanliness);
    }
        

}
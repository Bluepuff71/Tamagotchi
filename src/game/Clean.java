package game;

import game.core.interfaces.IInteractable;

public class Clean implements IInteractable {

    @Override
    public void interact(Tamagotchi tamagotchi) {
        int cleanliness = tamagotchi.getCleanliness();
        
        cleanliness += 10;

        tamagotchi.setCleanliness(cleanliness);
    }
        

}
package game.items;

import game.Tamagotchi;
import game.core.abstracts.Playable;

/**
 * Playable ball
 */
public final class Ball extends Playable {
    public Ball(){
        this.setCost(100);
        this.setDescription("Ball for playing fetch!");
        this.setName("Ball");
    }

    /**
     * Increase mood +10, Decrease cleanliness -10
     * @param tamagotchi the tamagotchi
     */
    @Override
    public void interact(Tamagotchi tamagotchi) {
        tamagotchi.setMood(tamagotchi.getMood()+10);
        tamagotchi.setCleanliness(tamagotchi.getCleanliness()-10);
    }
}

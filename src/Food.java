/**
 * Base class for any item that can be eaten
 */
public abstract class Food extends Item implements IConsumable {

    @Override
    public final void consume(Tamagotchi tamagotchi) {
        eat(tamagotchi);
        //Remove from inventory
    }

    public abstract void eat(Tamagotchi tamagotchi);
}

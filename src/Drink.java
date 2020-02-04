/**
 * Base class for any item that can be drunk
 */
public abstract class Drink extends Item implements IConsumable {

    @Override
    public final void consume(Tamagotchi tamagotchi) {
        drink(tamagotchi);
        //Remove from inventory
    }

    public abstract void drink(Tamagotchi tamagotchi);
}

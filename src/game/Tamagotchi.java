package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import game.core.abstracts.Item;
import game.core.enums.MoodStates;
import game.core.enums.Personality;
import game.core.interfaces.IInteractable;
import game.core.interfaces.IPerishable;
import game.items.Drinks.Soda;
import game.items.Foods.Burger;
import game.items.Soaps.Soap;
import game.items.Toys.Ball;
import jdk.jshell.spi.ExecutionControl;

public final class Tamagotchi implements IPerishable, Serializable {

    /**
     * The universally unique identifier (UUID) of the Tamagotchi
     */
    private final UUID uuid;

    /**
     * The name of the Tamagotchi
     */
    private String name;

    /**
     * The current hunger (0-100)
     */
    private int food;

    /**
     * The current thirst (0-100)
     */
    private int water;

    /**
     * The current dirtiness (0-100)
     */
    private int cleanliness;

    /**
     * The current value of the mood (0-125)
     * Used to determine the mood state
     * Do not use this directly!
     */
    private int mood;
    //private img sprite

    /**
     * The amount of money the Tamagotchi has
     */
    private int money;

    /**
     * The Tamagotchi's personality
     */
    private Personality personality;

    /**
     * The Tamagotchi's difficulty multiplier
     * Changes how fast the Tamagotchi's stats decrease.
     */
    private int difficulty;

    /**
     * The inventory of the Tamagotchi
     */
    private ArrayList<Item> inventory = new ArrayList<>(){
        {
            add(new Ball());
            add(new Soap());
            add(new Burger());
            add(new Soda());
        }
    };

    /**
     * Creates a new Tamagotchi with default values and a random personality
     * @param name the name of the Tamagotchi
     */
    public Tamagotchi(String name){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.food = 100;
        this.water = 100;
        this.cleanliness = 100;
        this.mood = 100;
        this.money = 100;
        this.personality = generatePersonality();
    }

    /**
     * Generates a random personality and returns it
     * @return a random personality
     */
    private Personality generatePersonality(){
        return Personality.values()[new Random().nextInt(Personality.values().length - 1)];
    }

    /**
     * Clamps the given x value to the range (min, max)
     * @param min the minimum number (inclusive)
     * @param max the maximum number (inclusive)
     * @param x the number to clamp
     * @return the clamped number
     */
    private int clamp(int min, int max, int x){
        if(x > max){
            return max;
        } else if(x < min){
            return min;
        } else {
            return x;
        }
    }

    /**
     * Decrements all the stats by 1
     */
    public void decrementStats(){
        this.setFood(this.food - 1);
        this.setWater(this.water - 1);
        this.setCleanliness(this.cleanliness - 1);
        this.setMood(this.mood - 1);
    }

    //Getters and Setters


    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = clamp(0,100, food);
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = clamp(0,100, water);
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = clamp(0,100, cleanliness);;
    }

    public MoodStates getMoodState() {
        if(mood == 0){
            return MoodStates.DEAD;
        } else if(mood >= 1 && mood <= 30){
            return MoodStates.SAD;
        } else if(mood >= 31 && mood <= 60){
            return MoodStates.NEUTRAL;
        } else {
            return MoodStates.HAPPY;
        }
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = clamp(0,125, mood);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    /*public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }*/

    @SuppressWarnings("unchecked")
    public <T extends Item> ArrayList<T> getInventory(Class<T> classToLookFor){
        ArrayList<T> items = new ArrayList<>();
        for (Item item : inventory) {
            if(classToLookFor.isAssignableFrom(item.getClass())){
                items.add((T) item);
            }
        }
        return items;
    }

    @Override
    public String toString() {
        return String.format("%s | %s\n" +
                "Money: %d\n" +
                "Food: %d\n" +
                "Water: %d\n" +
                "Cleanliness: %d\n" +
                "Inventory: %s\n", this.name, this.getMoodState(),this.money, this.food, this.water, this.cleanliness, this.inventory.get(0).getName());
    }
}

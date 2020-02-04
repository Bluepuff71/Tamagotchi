import java.util.List;
import java.util.Random;
public class Tamagotchi implements ITamagotchi, IInteractable {
    private String name;
    private int food;
    private int water;
    private int cleanliness;
    private int mood;
    //private img sprite
    private int money;
    private Personality personality;
    private int difficulty;
    private List<Item> inventory;

    public Tamagotchi(String name){
        this.name = name;
        this.food = 100;
        this.water = 100;
        this.cleanliness = 100;
        this.mood = 100;
        this.money = 100;
        this.personality = generatePersonality();
    }

    private Personality generatePersonality(){
        return Personality.values()[new Random().nextInt() * Personality.values().length];
    }

    /**
     * Decrements all the stats by 1
     */
    public void decrimentStats(){
        this.food = this.food - 1;
        this.water = this.water - 1;
        this.cleanliness = this.cleanliness - 1;
        this.mood = this.mood - 1;
    }

    @Override
    public void Interact(ITamagotchi iTamagotchi) {
        System.out.println("Communication");
    }

    //Getters and Setters
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
        this.food = food;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public MoodStates getMoodState() {
        if(mood == 0){
            return MoodStates.DEAD;
        } else if(mood >= 1 && mood <= 30){
            return MoodStates.SAD;
        } else if(mood >= 31 && mood <= 60){
            return MoodStates.NEUTRAL;
        } else if(mood >= 61 && mood <= 100){
            return MoodStates.HAPPY;
        } else {
            return MoodStates.INVALID;
        }
    }

    public void setMood(int mood) {
        this.mood = mood;
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

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Tamagotchi Stats and stuff";
    }
}

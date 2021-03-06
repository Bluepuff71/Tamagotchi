package game.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import org.javatuples.Pair;

import game.Tamagotchi;
import game.core.abstracts.Drink;
import game.core.abstracts.Food;
import game.core.abstracts.Playable;
import game.core.abstracts.Cleanable;
import game.io.GameIO;
import javatech.GameThread;
import javatech.input.Input;
import javatech.ui.GUI;
import javatech.ui.TextGUI;

public class Game extends GUI {

    private GameThread gameThread;

    private Tamagotchi tamagotchi;

    private Pair<Integer,Boolean> menuResponse;

    public Game(Tamagotchi tamagotchi, GameThread gameThread){
        this.tamagotchi = tamagotchi;
        this.gameThread = gameThread;
    }
    public Game(Tamagotchi tamagotchi){
        this.tamagotchi = tamagotchi;
        gameThread = new GameThread(tamagotchi, 1000);
    }

    @Override
    public void draw(Graphics g, Input input) {
        g.setFont(new Font("Impact", Font.PLAIN, 30));
        g.setColor(Color.WHITE);
        g.drawString(String.format("%s : %s", tamagotchi.getName(), tamagotchi.getMoodState()), 300,120);
        g.drawString(String.format("Money: %d", tamagotchi.getMoney()), 300,150);
        g.drawString(String.format("Food: %d", tamagotchi.getFood()), 300,180);
        g.drawString(String.format("Water: %d", tamagotchi.getWater()), 300,210);
        g.drawString(String.format("Cleanliness: %d", tamagotchi.getCleanliness()), 300,240);
        menuResponse = TextGUI.selectableMenu(g, 300, 270, input, "W", "S", "Enter", Color.WHITE, Color.GREEN,  menuResponse, 
        "What would you like to say?",
                "Feed",
                "Water",
                "Clean",
                "Play",
                "Communicate",
                "Save and Quit");
        if(menuResponse.getValue1()){
            menuResponse = menuResponse.setAt1(false);
            switch (menuResponse.getValue0()){
                case 0:
                    ArrayList<Food> foods = tamagotchi.getInventory(Food.class);
                    foods.get(0).eat(tamagotchi);
                    break;
                case 1:
                    ArrayList<Drink> drinks = tamagotchi.getInventory(Drink.class);
                    drinks.get(0).drink(tamagotchi);
                    break;
                case 2:
                    ArrayList<Cleanable> cleanables = tamagotchi.getInventory(Cleanable.class);
                    cleanables.get(0).interact(tamagotchi);
                    break;
                case 3:
                    ArrayList<Playable> playables = tamagotchi.getInventory(Playable.class);
                    playables.get(0).interact(tamagotchi);
                    break;
                case 4:
                    getWindow().drawGUI(new CommunicateGUI(this.tamagotchi, this.gameThread));
                    exit();
                    break;
                case 5:
                    System.out.println("Save and Quit");
                    try{
                        GameIO.SaveTamagotchi(tamagotchi);
                    } catch (IOException e){
                        System.out.println("There was a problem saving your tamagotchi");
                    }
                    getWindow().drawGUI(new MainMenu());
                    exit();
                default:
                    break;
            }
        }

    }
}

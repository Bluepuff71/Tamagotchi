package game.ui;

import java.awt.*;

import game.Communicate;
import game.Tamagotchi;
import javatech.input.*;
import javatech.ui.*;

import org.javatuples.Pair;

public class CommunicateGUI extends GUI {

    private Tamagotchi tamagotchi;
    private Communicate speech;
    private Pair<Integer,Boolean> menuResponse;

    public CommunicateGUI(Tamagotchi tamagotchi){
        this.tamagotchi = tamagotchi;
        this.speech = new Communicate(tamagotchi.getMoodState(), tamagotchi.getPersonality());
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
             "What would you like to do?",
                "say 'Hello'",
                "say 'How are you?'",
                "say 'Want to Play?'",
                "Go Back to Main Menu");
        if(menuResponse.getValue1()){
            menuResponse = menuResponse.setAt1(false);
            switch (menuResponse.getValue0()){
                case 0:
                    g.drawString(String.format("%s", speech.getSpeechAnswer("A")), 100,180);
                    break;
                case 1:
                    g.drawString(String.format("%s", speech.getSpeechAnswer("B")), 100,180);
                    break;
                case 2:
                    g.drawString(String.format("%s", speech.getSpeechAnswer("C")), 100,180);
                    break;
                case 3:
                    getWindow().drawGUI(new Game(this.tamagotchi));
                    exit();
                    break;
                default:
                    break;
            }
        }

    }
}
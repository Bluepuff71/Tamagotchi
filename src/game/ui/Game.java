package game.ui;

import game.Communicate;
import game.Tamagotchi;
import game.core.enums.speech.PlayerSpeechOptions;
import javatech.GameThread;
import javatech.ui.GUI;
import javatech.input.Input;
import javatech.ui.TextGUI;
import org.javatuples.Pair;
import org.javatuples.Tuple;

import java.awt.*;

public class Game extends GUI {

    private Tamagotchi tamagotchi;

    Pair<Integer,Boolean> menuResponse;

    public Game(Tamagotchi tamagotchi){
        this.tamagotchi = tamagotchi;
        System.out.println(this.tamagotchi);
        new GameThread(tamagotchi);
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
        menuResponse = TextGUI.selectableMenu(g, 300, 270, input, "W", "S", "Enter", Color.WHITE, Color.GREEN,  menuResponse, "What would you like to do?",
                "Feed",
                "Water",
                "Clean",
                "Play",
                "Communicate");
        if(menuResponse.getValue1()){
            switch (menuResponse.getValue0()){
                case 0:
                    System.out.println("Feed");
                    break;
                case 1:
                    System.out.println("Water");
                    break;
                case 2:
                    System.out.println("Clean");
                    break;
                case 3:
                    System.out.println("Play");
                    break;
                case 4:
                    System.out.println("Communicate");
                    break;
                default:
                    break;
            }
        }

    }
}

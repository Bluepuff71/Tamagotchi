package game.ui;

import java.awt.*;
import java.util.EnumSet;

import game.Tamagotchi;
import javatech.input.*;
import javatech.ui.*;
import javatech.ui.enums.*;
import org.javatuples.Pair;

public class MainMenu extends GUI {

    private Pair<Integer, Boolean> menuResponse;

    private String name = "";

    @Override
    public void draw(Graphics g, Input input) {
        g.setFont(new Font("Impact", Font.PLAIN, 30));
        menuResponse = TextGUI.selectableMenu(g, 300, 50, input, "W", "S", "Enter", Color.white, Color.GREEN, menuResponse, "Tamagotchi V0.0.1",
                "[1] Create a Tamagotchi",
                "[2] Load a Tamagotchi",
                "[3] Quit");
        g.drawString(String.valueOf(menuResponse.getValue0()), 50,50);
        if(menuResponse.getValue1()){
            switch (menuResponse.getValue0()){
                case 0:{
                    g.drawString("Time to create your Tamagotchi", 300, 50);
                    g.drawString("First, you need to name it!", 300, 80);
                    name = TextGUI.textField(g, 300, 110, input, "Enter its name: ", name, EnumSet.of(TextFieldFilterFlags.ALPHABETIC, TextFieldFilterFlags.DIGIT));
                    if(input.getKeyDown("Enter")){
                        getWindow().drawGUI(new Game(new Tamagotchi(name)));
                        exit();
                    }
                    break;
                }
                case 1:{
                    getWindow().drawGUI(new LoadTamagotchi());
                    exit();
                    break;
                }
                case 2:{
                    exit();
                    System.exit(1);
                    break;
                }
                default:
                    break;
            }
        }


    }
}

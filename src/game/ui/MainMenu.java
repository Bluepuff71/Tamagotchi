package game.ui;

import java.awt.*;
import java.util.EnumSet;

import game.Tamagotchi;
import javatech.input.*;
import javatech.ui.*;
import javatech.ui.enums.*;

public class MainMenu extends GUI {

    private int selectedItem = 0;

    private int mainSelection = -1;

    private String name = "";

    @Override
    public void draw(Graphics g, Input input) {
        g.setFont(new Font("Impact", Font.PLAIN, 30));
        g.drawString(String.valueOf(mainSelection), 50,50);
        switch (mainSelection){
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
                g.drawString("2", 50,50);
                break;
            }
            case 2:{
                g.drawString("3", 50,50);
                break;
            }
            default:{
                mainSelection = TextGUI.selectableMenu(g, 300, 50, input, "W", "S", "Enter", Color.white, Color.GREEN, selectedItem, "Tamagotchi V0.0.1",
                        "[1] Create a Tamagotchi",
                        "[2] Load a Tamagotchi",
                        "[3] Quit");
                break;
            }
        }

    }
}

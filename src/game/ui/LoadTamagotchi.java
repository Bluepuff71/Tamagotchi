package game.ui;

import game.Tamagotchi;
import game.io.GameIO;
import javatech.input.Input;
import javatech.ui.GUI;
import javatech.ui.TextGUI;
import org.javatuples.Pair;

import java.awt.*;
public class LoadTamagotchi extends GUI {

    private Pair<Integer, Boolean> menuResponse;

    private Tamagotchi[] tamagotchies;

    private String[] tamagotchiNames;

    public LoadTamagotchi(){
        tamagotchies = GameIO.LoadAllTamagotchies();
        if(tamagotchies != null) {
            tamagotchiNames = new String[tamagotchies.length];
            for (int i = 0; i < tamagotchies.length; i++) {
                tamagotchiNames[i] = tamagotchies[i].getName();
            }
        }
    }

    @Override
    public void draw(Graphics g, Input input) {
        if(tamagotchies == null){
            System.out.println("No Tamagotchies were found.");
            getWindow().drawGUI(new MainMenu());
            exit();
        } else {
            menuResponse = TextGUI.selectableMenu(g, 300, 200, input, "W", "S", "Enter", Color.WHITE, Color.GREEN, menuResponse, "Which Tamagotchi do you want to load?", tamagotchiNames);
            if(menuResponse.getValue1()){
                getWindow().drawGUI(new Game(tamagotchies[menuResponse.getValue0()]));
                exit();
            }
        }
    }
}

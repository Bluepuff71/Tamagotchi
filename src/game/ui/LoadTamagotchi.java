package game.ui;

import game.Tamagotchi;
import game.io.GameIO;
import javatech.input.Input;
import javatech.ui.GUI;
import javatech.ui.TextGUI;
import org.javatuples.Pair;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class LoadTamagotchi extends GUI {

    private Pair<Integer, Boolean> menuResponse;

    private ArrayList<Tamagotchi> tamagotchies;

    private String[] tamagotchiNames;

    public LoadTamagotchi(){
        try{
            tamagotchies = GameIO.LoadAllTamagotchies();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("There was an error getting a file.");
            e.printStackTrace();
        }
        if(tamagotchies != null) {
            tamagotchiNames = new String[tamagotchies.size()];
            for (int i = 0; i < tamagotchies.size(); i++) {
                tamagotchiNames[i] = tamagotchies.get(i).getName();
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
                getWindow().drawGUI(new Game(tamagotchies.get(menuResponse.getValue0())));
                exit();
            }
        }
    }
}

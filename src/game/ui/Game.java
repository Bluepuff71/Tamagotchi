package game.ui;

import game.Tamagotchi;
import javatech.ui.GUI;
import javatech.input.Input;

import java.awt.*;

public class Game extends GUI {

    private Tamagotchi tamagotchi;

    public Game(Tamagotchi tamagotchi){
        System.out.println("TEst");
        this.tamagotchi = tamagotchi;
    }

    @Override
    public void draw(Graphics g, Input input) {
        g.setFont(new Font("Impact", Font.PLAIN, 30));
        g.setColor(Color.WHITE);
        g.drawString(String.format("%s", tamagotchi.getName()), 50,100);
    }
}

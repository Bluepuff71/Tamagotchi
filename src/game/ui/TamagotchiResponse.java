package game.ui;

import java.awt.*;

import game.Tamagotchi;
import javatech.GameThread;
import javatech.input.*;
import javatech.ui.*;

public class TamagotchiResponse extends GUI {

    private String speech;
    private Tamagotchi tamagotchi;
    private GameThread gameThread;
    private int i;
    public TamagotchiResponse(String Response, Tamagotchi tamagotchi, GameThread gameThread){ 
        this.gameThread = gameThread;
        this.speech = Response;
        this.tamagotchi = tamagotchi;
        this.i = 0;
    }

    @Override
    public void draw(Graphics g, Input input) {        
        g.setFont(new Font("Impact", Font.PLAIN, 100));
        g.setColor(Color.WHITE);
        g.drawString(String.format("%s" ,this.speech), 50,120);

        if(i==30){
            getWindow().drawGUI(new Game(this.tamagotchi, this.gameThread));
            exit();  
        }
           
        i++;
    }
}
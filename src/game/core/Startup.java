package game.core;


import game.ui.MainMenu;
import javatech.ui.Window;

public class Startup {
    public static void main(String[] args){
        Window window = new Window("Tamagotchi", 800, 600, false);
        window.drawGUI(new MainMenu());
    }


}

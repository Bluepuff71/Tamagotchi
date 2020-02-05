import javax.swing.*;

public class Startup extends JFrame {
    //Startup Method, we can ignore
    public static void main(String[] args){
        new Startup();
    }

    public Startup(){

        super("Tamagotchi");
        setSize(800, 600);

        MainMenu mainMenu = new MainMenu();

        mainMenu.setFocusable(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(mainMenu);
        setVisible(true);
    }


}

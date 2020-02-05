import java.awt.*;

public class MainMenu extends GUI{

    private int selectedItem;

    private int mainSelection = -1;

    private String name = "";

    @Override
    public void draw(Graphics g, Input input) {
        g.setFont(new Font("Impact", Font.PLAIN, 30));
        //Not Working yet
        if(input.getKeyDown("W")){
            selectedItem--;
        }
        if(input.getKeyDown("S")){
            selectedItem++;
        }
        g.drawString(String.valueOf(mainSelection), 50,50);
        switch (mainSelection){
            case 0:{
                g.drawString("Time to create your Tamagotchi", 300, 50);
                g.drawString("First, you need to name it!", 300, 80);
                name = TextGUI.textField(g, "Enter its name: ", name, input, 300, 110);
                if(input.getKeyDown("Enter")){
                   //new Game(new Tamagotchi(name));
                   g.drawString("Test", 50,100);
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
                mainSelection = TextGUI.selectableMenu(g, 300, 50, input, Color.white, Color.GREEN,"Enter", selectedItem, "Tamagotchi V0.0.1",
                        "[1] Create a Tamagotchi",
                        "[2] Load a Tamagotchi",
                        "[3] Quit");
                break;
            }
        }

    }
}

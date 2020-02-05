import java.awt.*;

public class TextGUI {

    public static int selectableMenu(Graphics g, int x, int y, Input input, Color original, Color selected, String keyText, int selectedItem, String title, String... options){
        g.drawString(title, x, y);
        for (int i = 0; i < options.length; i++) {
            if(i == selectedItem % options.length){
                g.setColor(selected);
            } else {
                g.setColor(original);
            }
            g.drawString(options[i], x, y + ((i+1) * g.getFont().getSize()));
        }
        g.setColor(original);
        if(input.getKeyDown(keyText)){
            return selectedItem % options.length;
        } else {
            return -1;
        }
    }

    public static String textField(Graphics g, String label, String text, Input input, int x, int y){
        text += input.getKey();
        g.drawString(String.format("%s%s", label, text), x, y);
        return text;
    }
}

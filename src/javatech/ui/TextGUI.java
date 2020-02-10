package javatech.ui;

import javatech.input.Input;
import javatech.ui.enums.TextFieldFilterFlags;
import org.javatuples.Pair;

import java.awt.*;
import java.util.EnumSet;

/**
 * Provides tools for creating complex text-based menu items on a GUI
 * @see GUI
 */
public final class TextGUI {

    private static int clamp(int num, int max){
        return ((num-1) % max + max) % max;
    }

    /**
     * Prints a selectable menu to the screen
     * @param g the graphics of the menu
     * @param x the x-position
     * @param y the y-position
     * @param input the input instance to use
     * @param upKey the key to use for moving up in the menu
     * @param downKey the key to use for moving down in the menu
     * @param selectKey the key to use for making a selection in the menu
     * @param original the color of the unselected text
     * @param selected the color of the highlighted text
     * @param pair the tuple containing the data to modify
     * @param title the title of the menu
     * @param options the options to choose from within the menu
     * @return a tuple containing the currently highlighted item and if it has been selected
     */
    public static Pair<Integer, Boolean> selectableMenu(Graphics g, int x, int y, Input input, String upKey, String downKey, String selectKey, Color original, Color selected, Pair<Integer, Boolean> pair, String title, String... options){
        if(pair != null && pair.getValue1()){
            return pair;
        }
        int selectedItem = (pair != null) ? pair.getValue0() : 0;
        selectedItem = selectedItem - (options.length - 1);
        selectedItem = clamp(selectedItem, options.length);
        g.drawString(title, x, y);
        g.drawString(String.valueOf(selectedItem), 70, 70);
        for (int i = 0; i < options.length; i++) {
            if(i == selectedItem){
                g.setColor(selected);
            } else {
                g.setColor(original);
            }
            g.drawString(options[i], x, y + ((i+1) * g.getFont().getSize()));
        }
        g.setColor(original);
        if(input.getKeyDown(upKey)){
            selectedItem--;
        } else if(input.getKeyDown(downKey)){
            selectedItem++;
        }
        if(input.getKeyDown(selectKey)){
            input.flush();
            return new Pair<Integer, Boolean>(selectedItem, true);
        } else {
            return new Pair<Integer,Boolean>(selectedItem, false);
        }
    }

    /**
     * Creates a labeled field that can be typed into.
     * @param g graphics of the GUI
     * @param x the x-position on the GUI
     * @param y the y-position on the GUI
     * @param input the input cf the GUI
     * @param label the label of the field
     * @param text the text to use inside the field
     * @param textFilter the filter that determines what text is allowed to be typed into the field
     * @return the text inside the field
     */
    public static String textField(Graphics g, int x, int y, Input input, String label, String text, EnumSet<TextFieldFilterFlags> textFilter){
        String temp = input.getKey();
        switch (temp){
            case "\b":
                if(text.length() > 0){
                    text = text.substring(0, text.length() - 1);
                }
                break;
            case "":
            case "\n":
            case "\t":
            case "\r":
            case "\f":
                break;
            default:
                if(textFilter.contains(TextFieldFilterFlags.ALPHABETIC) && Character.isAlphabetic(temp.toCharArray()[0])){
                    text += temp;
                }
                if (textFilter.contains(TextFieldFilterFlags.DIGIT) && Character.isDigit(temp.toCharArray()[0])){
                    text += temp;
                }
                if (textFilter.contains(TextFieldFilterFlags.SPECIAL) && !Character.isLetterOrDigit(temp.toCharArray()[0])){
                    text += temp;
                }
                break;
        }
        g.drawString(String.format("%s%s_", label, text), x, y);
        return text;
    }
}

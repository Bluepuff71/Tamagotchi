package javatech.ui;

import javatech.input.Input;
import javatech.ui.enums.TextFieldFilterFlags;

import java.awt.*;
import java.util.EnumSet;

public final class TextGUI {

    private static int clamp(int num, int max){
        return ((num-1) % max + max) % max;
    }

    public static int selectableMenu(Graphics g, int x, int y, Input input, Color original, Color selected, String keyText, int selectedItem, String title, String... options){
        selectedItem = selectedItem - 2;
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
        if(input.getKeyDown(keyText)){
            return selectedItem;
        } else {
            return -1;
        }
    }

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

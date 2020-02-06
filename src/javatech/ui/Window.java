package javatech.ui;

import javax.swing.*;

public final class Window extends JFrame {

    public Window(String name, int xSize, int ySize, boolean isResizable){
        super(name);
        setSize(xSize, ySize);
        setResizable(isResizable);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void drawGUI(GUI toDraw){
        getContentPane().add(toDraw);
        setFocusable(true);
        validate();
    }
}

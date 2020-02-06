package javatech.ui;

import javatech.input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Provides a powerful and simple to use wrapper for creating UIs within Windows
 * @see Window
 */
public abstract class GUI extends Canvas implements Runnable {

    private Thread guiThread;

    private Input input;

    private BufferedImage back;

    private Color backgroundColor;

    private Color textColor;

    private boolean isExiting;

    /**
     * Creates a new GUI with a black background and white text color.
     */
    public GUI(){
        this.backgroundColor = Color.BLACK;
        this.textColor = Color.WHITE;
        setBackground(Color.BLACK);
        setVisible(true);
        this.setupGUIThread();
        this.setupInput();
    }

    /**
     * Creates a new GUI.
     * @param backgroundColor the initial color of the background
     * @param textColor the initial color of text
     */
    public GUI(Color backgroundColor, Color textColor){
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        setBackground(backgroundColor);
        setVisible(true);
        this.setupGUIThread();
        this.setupInput();
    }

    private void setupGUIThread(){
        guiThread = new Thread(this);
        guiThread.start();
    }

    private void setupInput(){
        this.input = new Input();
        addKeyListener(input); //starts key listening thread
    }


    @Override
    public final void run() {
        try {
            while (!guiThread.isInterrupted()) {
                Thread.sleep(100);
                repaint();
            }
        } catch (InterruptedException ignore) {

        } catch (Exception e){
            System.out.println("Big Error. Tell Emery!");
            e.printStackTrace();
        }
    }

    @Override
    public final void paint(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g; //Sets up double buffering

        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        graphToBack.setColor(this.backgroundColor);
        graphToBack.fillRect(getX(), getY(), getWidth(), getHeight()); //Draw over previous frame
        graphToBack.setColor(this.textColor);
        if(!isExiting){
            draw(graphToBack, this.input);
        }
        graphics2D.drawImage(back, null, 0,0);
        if(isExiting){
            getWindow().remove(this);
            guiThread.interrupt();
        }
    }

    /**
     * Exits the GUI and kills the thread.
     */
    protected final void exit(){
        this.isExiting = true;
    }

    /**
     * Gets the Window that the GUI is contained within
     * @return the Window this GUI is contained within
     * @see Window
     */
    protected final Window getWindow(){
        return (Window) SwingUtilities.getWindowAncestor(this);
    }

    /**
     * Method for drawing double buffered GUI's
     * @param g the graphics to draw onto
     * @param input the input for listening for key presses
     */
    public abstract void draw(Graphics g, Input input);
}

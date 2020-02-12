package javatech.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * Provides an simple API for getting keyboard inputs
 */
public class Input implements KeyListener {

    private HashMap<String, Boolean> keys = new HashMap<>();

    private String lastKeyPressed;

    /**
     * Returns true the frame the specified key is pressed down
     * @param keyText the key to listen for
     * @return true if the key was pressed
     */
    public boolean getKeyDown(String keyText){
        return keys.getOrDefault(keyText, false);
    }

    /**
     * Returns true the frame the specified key is released
     * @param keyText the key to listen for
     * @return true if the key was released
     */
    public boolean getKeyUp(String keyText){
        return !keys.getOrDefault(keyText, false);
    }

    /**
     * Gets the name of the last key that was pressed down
     * @return the name of the last key that was pressed down
     */
    public String getKey(){
        String key = lastKeyPressed;
        lastKeyPressed = "";
        return key;
    }

    /**
     * Flushes the key buffer.
     */
    public void flush(){
        keys.clear();
        lastKeyPressed = "";
    }

    @Override
    public void keyTyped(KeyEvent e) {
        lastKeyPressed = String.valueOf(e.getKeyChar());
        if(Integer.valueOf(lastKeyPressed) == 10){
            lastKeyPressed = "Enter";
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys.put(KeyEvent.getKeyText(e.getKeyCode()), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.put(KeyEvent.getKeyText(e.getKeyCode()), false);
    }
}

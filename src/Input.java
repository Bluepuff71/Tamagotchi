import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Input implements KeyListener {

    private HashMap<String, Boolean> keys = new HashMap<>();

    private String lastKeyPressed;

    public boolean getKeyDown(String keyText){
        return keys.getOrDefault(keyText, false);
    }

    public boolean getKeyUp(String keyText){
        return !keys.getOrDefault(keyText, false);
    }

    public String getKey(){
        String key = lastKeyPressed;
        lastKeyPressed = "";
        return key;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        lastKeyPressed = String.valueOf(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
        keys.put(KeyEvent.getKeyText(e.getKeyCode()), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.put(KeyEvent.getKeyText(e.getKeyCode()), false);
    }
}

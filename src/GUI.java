import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GUI extends Canvas implements Runnable {

    private Thread guiThread;

    private Input input;

    private BufferedImage back;

    private Color backgroundColor;

    private Color textColor;

    private boolean isExiting;


    public GUI(){
        this.backgroundColor = Color.BLACK;
        this.textColor = Color.WHITE;
        setBackground(Color.BLACK);
        setVisible(true);
        this.setupGUIThread();
        this.setupInput();
    }

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
            guiThread.interrupt();
        }
    }

    protected final void exit(){
        this.isExiting = true;
    }

    /**
     * Method for drawing double buffered GUI's
     * @param g the graphics to draw onto
     * @param input the input for listening for key presses
     */
    public abstract void draw(Graphics g, Input input);
}

package javatech;

import game.core.interfaces.IPerishable;

/**
 * The thread in charge of decrementing perishables
 */
public class GameThread implements Runnable {

    private Thread gameThread;

    private IPerishable perishable;

    private int sleepTime;
    
    public GameThread(IPerishable perishable, int sleepTime){
        GameThreadFactory(perishable, sleepTime);
    }

    public GameThread(IPerishable perishable){
        GameThreadFactory(perishable, 10000);
    }

    private void GameThreadFactory(IPerishable perishable, int sleepTime){
        this.perishable = perishable;
        this.sleepTime = sleepTime;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        try {
            while (!gameThread.isInterrupted()) {
                if(sleepTime > 0){
                    Thread.sleep(sleepTime);
                }
                perishable.decrementStats();
            }
        } catch (InterruptedException ignore) {

        }
    }
}

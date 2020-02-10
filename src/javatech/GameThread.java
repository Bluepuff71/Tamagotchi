package javatech;

import game.core.interfaces.IPerishable;

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
                Thread.sleep(sleepTime);
                perishable.decrementStats();
            }
        } catch (InterruptedException ignore) {

        } catch (Exception e){
            System.out.println("Big Error. Tell Emery!");
            e.printStackTrace();
        }
    }
}

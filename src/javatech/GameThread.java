package javatech;

import game.core.interfaces.IPerishable;

public class GameThread implements Runnable {

    private Thread gameThread;

    private IPerishable perishable;

    public GameThread(IPerishable perishable){
        this.perishable = perishable;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        try {
            while (!gameThread.isInterrupted()) {
                Thread.sleep(10000);
                perishable.decrementStats();
            }
        } catch (InterruptedException ignore) {

        } catch (Exception e){
            System.out.println("Big Error. Tell Emery!");
            e.printStackTrace();
        }
    }
}

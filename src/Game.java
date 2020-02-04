public class Game implements Runnable {

    private Tamagotchi tamagotchi;
    /**
     * Starts up the Game Thread.
     */
    public Game(Tamagotchi tamagotchi){
        this.tamagotchi = tamagotchi;
        new Thread(this).start();
        gameUI();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                update();
            }
        } catch (Exception e) {
            System.out.println("Big Error. Tell Emery!");
        }
    }

    /**
     * The heartbeat of the game. Runs every 100ms.
     */
    private void update(){
        tamagotchi.decrimentStats();
    }

    //Text based UI Methods
    private void gameUI(){
        System.out.println(tamagotchi); //Print the tamagotchi stats (toString)
        System.out.println("What would you like to do?");
        System.out.println("[1] Feed");
        System.out.println("[2] Water");
        System.out.println("[3] Play");
        System.out.println("[4] Clean");
        System.out.println("[5] Talk");
        System.out.println("[6] Quit");
    }


}

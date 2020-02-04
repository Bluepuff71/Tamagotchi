import java.util.Scanner;

public class Main {
    //Main Method, we can ignore
    public static void main(String[] args){
        new Main();
    }

    public Main(){
        mainMenu();
    }

    Scanner scanner = new Scanner(System.in);

    void mainMenu(){
        System.out.println("Tamagotchi V0.0.1");
        System.out.println("[1] Create a Tamagotchi");
        System.out.println("[2] Load a Tamagotchi");
        System.out.println("[3] Quit");
        System.out.print("Please type your option: ");
        while (!scanner.hasNextInt()){
            System.out.println("That is not an option.");
            scanner.nextLine(); //clear the scanner buffer
            mainMenu();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); //clear the scanner buffer
        switch (choice){
            case 1:{
                createTamagotchi();
            }
            case 2:{
                loadTamagotchi();
            }
            case 3:{
                //quit
            }
            default:{
                System.out.println("That is not an option.");
                mainMenu();
            }
        }
    }

    private void createTamagotchi(){
        System.out.println("Time to create your Tamagotchi!");
        System.out.println("First, you need to name it!");
        System.out.print("Enter its name: ");
        String name = scanner.nextLine();
        System.out.println("Perfect!");
        System.out.println("Creating your Tamagotchi...");
        new Game(new Tamagotchi(name));
    }

    private void loadTamagotchi(){
        //Load from file
    }

}

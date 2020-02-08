package game.io;

import game.Tamagotchi;
import javatech.io.BinarySerialization;

import java.io.File;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;

//TODO Documentation
public class GameIO {

    private static final Path TAMAGOTCHI_PATH = Path.of("PetData/");
    public static void SaveTamagotchi(Tamagotchi tamagotchi){
        try{
            BinarySerialization.Serialize(tamagotchi, new File(TAMAGOTCHI_PATH.toString(), tamagotchi.getUuid().toString() + ".dat"));
        } catch (IOException e){
            System.out.println("There was an error saving tamagotchi.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Tamagotchi> LoadAllTamagotchies(){
        ArrayList<Tamagotchi> tamagotchies = new ArrayList<>();
        try{
            File tamagotchiDataFolder = TAMAGOTCHI_PATH.toFile();
            File[] files = tamagotchiDataFolder.listFiles();
            if(files == null){
                throw new NullPointerException();
            } else {
                for (File file: files) {
                   tamagotchies.add(BinarySerialization.Deserialize(file));
                }
            }
        } catch (IOException | ClassNotFoundException e){
            System.out.println("There was an error getting a file.");
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("No tamagotchi data folder exists");
        }
        return tamagotchies;
    }
}

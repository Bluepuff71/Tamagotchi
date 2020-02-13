package game.io;

import game.Tamagotchi;
import javatech.io.BinarySerialization;

import java.io.File;
import java.nio.file.Path;
import java.io.IOException;

/**
 * Contains utilites for game-related IO
 */
public class GameIO {

    /**
     * The default path to the tamagotchi data folder
     */
    private static final Path TAMAGOTCHI_PATH = Path.of("PetData/");

    /**
     * Saves the specified tamagotchi to the tamagotchi data folder in the format {@code UUID.dat}
     * @param tamagotchi the tamagotchi to save
     */
    public static void SaveTamagotchi(Tamagotchi tamagotchi){
        try{
            CreateTamagotchiDataPathIfNoneExists();
            BinarySerialization.Serialize(tamagotchi, new File(TAMAGOTCHI_PATH.toString(), tamagotchi.getUuid().toString() + ".dat"));
        } catch (IOException e){
            System.out.println("There was an error saving tamagotchi.");
            e.printStackTrace();
        }
    }

    private static void CreateTamagotchiDataPathIfNoneExists(){
        TAMAGOTCHI_PATH.toFile().mkdir();
    }

    /**
     * Loads all tamagotchies in the tamagotchi data folder
     * @return an {@code Arraylist} containing all the loaded tamagotchies
     */
    public static Tamagotchi[] LoadAllTamagotchies(){
        Tamagotchi[] tamagotchies = null;
        try{
            File tamagotchiDataFolder = TAMAGOTCHI_PATH.toFile();
            File[] files = tamagotchiDataFolder.listFiles();
            if(files == null){
                throw new NullPointerException();
            } else if(files.length > 0) {
                tamagotchies = new Tamagotchi[files.length];
                for (int i = 0; i < files.length; i++){
                    tamagotchies[i] = BinarySerialization.Deserialize(files[i]);
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

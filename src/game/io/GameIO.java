package game.io;

import game.Tamagotchi;
import javatech.io.BinarySerialization;

import java.io.File;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;

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
    public static void SaveTamagotchi(Tamagotchi tamagotchi) throws IOException{
        CreateTamagotchiDataPathIfNoneExists();
        BinarySerialization.Serialize(tamagotchi, new File(TAMAGOTCHI_PATH.toString(), tamagotchi.getUuid().toString() + ".dat"));
    }

    private static void CreateTamagotchiDataPathIfNoneExists(){
        TAMAGOTCHI_PATH.toFile().mkdir();
    }

    /**
     * Loads all tamagotchies in the tamagotchi data folder
     * @return an {@code ArrayList} containing all the loaded tamagotchies
     */
    public static ArrayList<Tamagotchi> LoadAllTamagotchies() throws IOException, ClassNotFoundException {
        ArrayList<Tamagotchi> tamagotchies = null;
        try{
            File tamagotchiDataFolder = TAMAGOTCHI_PATH.toFile();
            File[] files = tamagotchiDataFolder.listFiles();
            if(files == null){
                throw new NullPointerException();
            } else if(files.length > 0) {
                tamagotchies = new ArrayList<>();
                for (File file : files) {
                    if (file != null) {
                        Tamagotchi temp = BinarySerialization.Deserialize(file);
                        if (temp != null) {
                            tamagotchies.add(temp);
                        }
                    }
                }
            }
        }
        catch (NullPointerException e){
            System.out.println("No tamagotchi data folder exists");
            return null;
        }
        return tamagotchies;
    }
}

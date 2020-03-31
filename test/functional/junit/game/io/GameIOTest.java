package game.io;

import game.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameIOTest {

    private static final Path TAMAGOTCHI_PATH = Path.of("PetData/");

    @Test
    public void saveTamagotchi(){
        try{
            Tamagotchi testTamagotchi = new Tamagotchi("Test");
            GameIO.SaveTamagotchi(testTamagotchi);
            ArrayList<Tamagotchi> tamagotchis = GameIO.LoadAllTamagotchies();
            for (Tamagotchi t: tamagotchis) {
                if(t.getUuid() == testTamagotchi.getUuid()){
                    Assert.assertEquals(testTamagotchi, t);
                }
            }
        } catch (Exception e){
            Assert.fail();
            e.printStackTrace();
        }
    }

    @Test
    public void loadTamagotchiWithNoFolder(){

        File[] files = TAMAGOTCHI_PATH.toFile().listFiles();
        if(files != null){
            for (File f: files) {
                f.delete();
            }
        }
        TAMAGOTCHI_PATH.toFile().delete();
        try{
            ArrayList<Tamagotchi> tamagotchis = GameIO.LoadAllTamagotchies();
            Assert.assertNull(tamagotchis);
        } catch (Exception e){
            Assert.fail();
        }
    }

    @Test
    public void saveTamagotchiIOException(){
        Tamagotchi t = new Tamagotchi(";   243~~~");
        try {
            GameIO.SaveTamagotchi(t);
        } catch (IOException e){
            Assert.fail();
        }
    }

    @Test
    public void loadAllTamagotchies() {
        Tamagotchi testTamagotchi = new Tamagotchi("Test");
        try {
            GameIO.SaveTamagotchi(testTamagotchi);
            ArrayList<Tamagotchi> tamagotchis = GameIO.LoadAllTamagotchies();
            for (Tamagotchi t: tamagotchis) {
                if(t.getUuid() == testTamagotchi.getUuid()){
                    Assert.assertEquals(testTamagotchi, t);
                }
            }
        } catch (Exception e){
            Assert.fail();
        }
    }
}
package javatech;

import game.Tamagotchi;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameThreadTest {

    @Test
    public void run() {
        Tamagotchi t = new Tamagotchi("Test");
        GameThread g = new GameThread(t);
        GameThread g2 = new GameThread(t, 0);
    }
}
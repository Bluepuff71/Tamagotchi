package game;

import game.core.enums.MoodStates;
import game.core.enums.Personality;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommunicateTest {

    @Test
    public void getHappyNormalSpeechAnswerA() {
        Communicate c = new Communicate(MoodStates.HAPPY, Personality.NORMAL);
        Assert.assertEquals("Hello!!", c.getSpeechAnswer("A"));
    }

    @Test
    public void getHappyNormalSpeechAnswerB() {
        Communicate c = new Communicate(MoodStates.HAPPY, Personality.NORMAL);
        Assert.assertEquals("Doing great!!", c.getSpeechAnswer("B"));
    }

    @Test
    public void getHappyNormalSpeechAnswerC() {
        Communicate c = new Communicate(MoodStates.HAPPY, Personality.NORMAL);
        Assert.assertEquals("Always!!", c.getSpeechAnswer("C"));
    }

    @Test
    public void getNeutralNormalSpeechAnswerA() {
        Communicate c = new Communicate(MoodStates.NEUTRAL, Personality.NORMAL);
        Assert.assertEquals("Hi", c.getSpeechAnswer("A"));
    }

    @Test
    public void getNeutralNormalSpeechAnswerB() {
        Communicate c = new Communicate(MoodStates.NEUTRAL, Personality.NORMAL);
        Assert.assertEquals("Doing ok.", c.getSpeechAnswer("B"));
    }

    @Test
    public void getNeutralNormalSpeechAnswerC() {
        Communicate c = new Communicate(MoodStates.NEUTRAL, Personality.NORMAL);
        Assert.assertEquals("Why not!", c.getSpeechAnswer("C"));
    }

    @Test
    public void getSadNormalSpeechAnswerA() {
        Communicate c = new Communicate(MoodStates.SAD, Personality.NORMAL);
        Assert.assertEquals("*Cries* Hi...", c.getSpeechAnswer("A"));
    }

    @Test
    public void getSadNormalSpeechAnswerB() {
        Communicate c = new Communicate(MoodStates.SAD, Personality.NORMAL);
        Assert.assertEquals("Feeling sad", c.getSpeechAnswer("B"));
    }

    @Test
    public void getSadNormalSpeechAnswerC() {
        Communicate c = new Communicate(MoodStates.SAD, Personality.NORMAL);
        Assert.assertEquals("That would be nice! *Wipes tears*", c.getSpeechAnswer("C"));
    }

    @Test
    public void getDeadNormalSpeechAnswerA() {
        Communicate c = new Communicate(MoodStates.DEAD, Personality.NORMAL);
        Assert.assertEquals("DEAD", c.getSpeechAnswer("A"));
    }

    @Test
    public void getDeadNormalSpeechAnswerB() {
        Communicate c = new Communicate(MoodStates.DEAD, Personality.NORMAL);
        Assert.assertEquals("DEAD", c.getSpeechAnswer("B"));
    }

    @Test
    public void getDeadNormalSpeechAnswerC() {
        Communicate c = new Communicate(MoodStates.DEAD, Personality.NORMAL);
        Assert.assertEquals("DEAD", c.getSpeechAnswer("C"));
    }
    
    @Test
    public void getHappyNotNormalSpeechAnswerA() {
        Communicate c = new Communicate(MoodStates.HAPPY, Personality.NOT_NORMAL);
        Assert.assertEquals("Hello!!", c.getSpeechAnswer("A"));
    }

    @Test
    public void getHappyNotNormalSpeechAnswerB() {
        Communicate c = new Communicate(MoodStates.HAPPY, Personality.NOT_NORMAL);
        Assert.assertEquals("Doing great!!", c.getSpeechAnswer("B"));
    }

    @Test
    public void getHappyNotNormalSpeechAnswerC() {
        Communicate c = new Communicate(MoodStates.HAPPY, Personality.NOT_NORMAL);
        Assert.assertEquals("Always!!", c.getSpeechAnswer("C"));
    }

    @Test
    public void getNeutralNotNormalSpeechAnswerA() {
        Communicate c = new Communicate(MoodStates.NEUTRAL, Personality.NOT_NORMAL);
        Assert.assertEquals("Hi", c.getSpeechAnswer("A"));
    }

    @Test
    public void getNeutralNotNormalSpeechAnswerB() {
        Communicate c = new Communicate(MoodStates.NEUTRAL, Personality.NOT_NORMAL);
        Assert.assertEquals("Doing ok.", c.getSpeechAnswer("B"));
    }

    @Test
    public void getNeutralNotNormalSpeechAnswerC() {
        Communicate c = new Communicate(MoodStates.NEUTRAL, Personality.NOT_NORMAL);
        Assert.assertEquals("Why not!", c.getSpeechAnswer("C"));
    }

    @Test
    public void getSadNotNormalSpeechAnswerA() {
        Communicate c = new Communicate(MoodStates.SAD, Personality.NOT_NORMAL);
        Assert.assertEquals("*Cries* Hi...", c.getSpeechAnswer("A"));
    }

    @Test
    public void getSadNotNormalSpeechAnswerB() {
        Communicate c = new Communicate(MoodStates.SAD, Personality.NOT_NORMAL);
        Assert.assertEquals("Feeling sad", c.getSpeechAnswer("B"));
    }

    @Test
    public void getSadNotNormalSpeechAnswerC() {
        Communicate c = new Communicate(MoodStates.SAD, Personality.NOT_NORMAL);
        Assert.assertEquals("That would be nice! *Wipes tears*", c.getSpeechAnswer("C"));
    }

    @Test
    public void getDeadNotNormalSpeechAnswerA() {
        Communicate c = new Communicate(MoodStates.DEAD, Personality.NOT_NORMAL);
        Assert.assertEquals("DEAD", c.getSpeechAnswer("A"));
    }

    @Test
    public void getDeadNotNormalSpeechAnswerB() {
        Communicate c = new Communicate(MoodStates.DEAD, Personality.NOT_NORMAL);
        Assert.assertEquals("DEAD", c.getSpeechAnswer("B"));
    }

    @Test
    public void getDeadNotNormalSpeechAnswerC() {
        Communicate c = new Communicate(MoodStates.DEAD, Personality.NOT_NORMAL);
        Assert.assertEquals("DEAD", c.getSpeechAnswer("C"));
    }
}
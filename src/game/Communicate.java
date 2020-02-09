package game;

import game.core.enums.MoodStates;
import game.core.enums.Personality;
// TODO: Add methods to control which set of speech options will be returned to the UI
import game.core.enums.speech.NormalSpeech;


/*
This class is used to get the speech options for a given time in the game - based on personality and current mood

So pass in the mood/personality if you want to get different then base speech options
*/
public class Communicate{

    public MoodStates currentMood;
    public Personality currentPersonality;

    public Communicate(){
        //Uses base Communication options
    }

    public Communicate(MoodStates mood, Personality personality){
        //Takes in the personality/mood to give a different set of communcations
        this.currentMood = mood;
        this.currentPersonality = personality;
    }
    public String getSpeechAnswer(String playerChoice){//pass in the players choice in a string
        //TODO: return right string without switch statements
        return(NormalSpeech.DEAD.A.getWords());
    }


}
package game;

import game.core.enums.MoodStates;
import game.core.enums.Personality;
// TODO: Add methods to control which set of speech options will be returned to the UI


/*
 This class is used to get the speech options for a given time in the game - based on personality and current mood

 So pass in the mood/personality if you want to get different then base speech options
*/
public class Communicate{

     private MoodStates currentMood;
     private Personality currentPersonality;

    public Communicate(){
        //Uses base Communication options
    }

    public Communicate(MoodStates mood, Personality personality){
        //Takes in the personality/mood to give a different set of communcations
        this.currentMood = mood;
        this.currentPersonality = personality;
    }
    public String getSpeechAnswer(){
        
    }


}
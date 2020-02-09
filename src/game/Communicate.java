package game;

import game.core.enums.MoodStates;
import game.core.enums.Personality;


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


    
}
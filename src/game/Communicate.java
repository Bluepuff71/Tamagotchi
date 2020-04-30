package game;

import game.core.enums.MoodStates;
import game.core.enums.Personality;
import game.core.enums.speech.NormalSpeech;
import game.core.enums.speech.NotNormalSpeech;


/*
This class is used to get the speech options for a given time in the game - based on personality and current mood

So pass in the mood/personality if you want to get different then base speech options
*/
public class Communicate{

    private int currentMood;
    private Personality currentPersonality;

    public Communicate(String mood, Personality personality){
        //Takes in the personality/mood to give a different set of communcations
        this.currentMood = this.convertMood(mood);
        this.currentPersonality = personality;
    }
    private int convertMood(String mood){
        switch(mood){
            case "HAPPY":
                return 3;
            case "NEUTRAL":
                return 2;
            case "SAD":
                return 1;
            default:
                return 0;
        }
    }
    private int convertPlayerSelection(String Choice){
        switch(Choice){
            case "A":
                return 0;
            case "B":
                return 1;
            default:
                return 2;
        }
    }
    public String getSpeechAnswer(String playerChoice){//pass in the players choice in a string
        if(this.currentPersonality == Personality.NORMAL){
            return NormalSpeech.speech[this.convertPlayerSelection(playerChoice)][this.currentMood];
        } else {
            return NotNormalSpeech.speech[this.convertPlayerSelection(playerChoice)][this.currentMood];
        }
    }
}
/*
Communicate speech = new Communicate(tamagotchi.getMoodState(),tamagotchi.getPersonality());
System.out.println(speech.getSpeechAnswer(PlayerSpeechOptions.A.name()));


*/
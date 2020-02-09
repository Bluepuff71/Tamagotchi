package game;
import game.core.enums.MoodStates;
import game.core.enums.Personality;
import game.core.enums.speech.NormalSpeech;
// TODO: Add methods to control which set of speech options will be returned to the UI
import game.core.enums.speech.PlayerSpeechOptions;



/*
This class is used to get the speech options for a given time in the game - based on personality and current mood

So pass in the mood/personality if you want to get different then base speech options
*/
public class Communicate{

    public int currentMood;
    public Personality currentPersonality;

    public Communicate(){
        //Uses base Communication options
    }

    public Communicate(MoodStates mood, Personality personality){
        //Takes in the personality/mood to give a different set of communcations
        this.currentMood = this.convertMood(mood);
        this.currentPersonality = personality;
    }
    private int convertMood(MoodStates mood){
        switch(mood){
            case HAPPY:
            return 3;
            case NEUTRAL:
            return 2;
            case SAD:
            return 1;
            case DEAD:
            return 0;
            default:
            return 3;
        }
    }
    private int convertPlayerSelection(String Choice){
        switch(Choice){
            case "A":
            return 0;
            case "B":
            return 1;
            case "C":
            return 2;
            default:
            return 0;
        }
    }
    public String getSpeechAnswer(String playerChoice){//pass in the players choice in a string
        //TODO: return right string without switch statements
        return NormalSpeech.speech[this.convertPlayerSelection(playerChoice)][this.currentMood];
    }
}
/*
Communicate speech = new Communicate(tamagotchi.getMoodState(),tamagotchi.getPersonality());
System.out.println(speech.getSpeechAnswer(PlayerSpeechOptions.A.name()));


*/
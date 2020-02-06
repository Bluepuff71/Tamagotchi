public class Communicate extends Tamagotchi{

     private MoodStates currentMood;
     private Personality currentPersonality;

    public Communicate(){
        //Uses base Communication options
        currentMood = None;
        currentPersonality = None;
    }

    public Communicate(MoodStates mood, Personality personality){
        //Takes in the personality/mood to give a different set of communcations
        this.currentMood = mood;
        this.currentPersonality = personality;
    }

    public enum getTamagotchiSpeech(){
        enum validTamagotchiSpeech;

        return validTamagotchiSpeech;
    }
}
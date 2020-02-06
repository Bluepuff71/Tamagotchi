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
    public playerSpeech(){
        @// TODO: 2/6/2020 basic player speech option, reading though speech enum
        for(PlayerSpeechOptions speech : PlayerSpeechOptions.values())//just prints the values
        {
            System.out.println(speech.getWords());
        }
    }
    public enum getTamagotchiSpeech(){


        return validTamagotchiSpeech;
    }
}
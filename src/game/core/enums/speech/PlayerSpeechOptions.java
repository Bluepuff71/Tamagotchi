//Surrounded with class just in case differernt types of speech added
public class PlayerSpeechOptions{
    public enum NormalSpeech{
        A("Hello"),
        B("How are you?"),
        C("Want to play?");

        private String words;

        NormalSpeech(String words) {
            this.words = words;
        }

        public String getWords() {
            return words;
        }
    }

/*
//Get all enums
for(PlayerSpeechOptions speech : PlayerSpeechOptions.values())
{
    System.out.println(speech.name() + " :: "+ speech.getWords());
}
 */
}


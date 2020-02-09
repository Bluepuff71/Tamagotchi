package game.core.enums.speech;

//Speech options for Normal Personality

public class NormalSpeech{
    
    public NormalSpeech(){
        
    }
    public enum DEAD{
        A ("DEAD"),
        B   ("DEAD"),
        C   ("DEAD");

        private String words;

        DEAD(String words) {
            this.words = words;
        }

        public String getWords() {
            return words;
        }
    }
    public enum SAD{
        A ("*Cries* Hi..."),
        B   ("Feeling sad"),
        C   ("That would be nice! *Wipes tears*");

        private String words;

        SAD(String words) {
            this.words = words;
        }

        public String getWords() {
            return words;
        }
    }
    public enum NEUTRAL{
        A ("Hi"),
        B   ("Doing ok."),
        C   ("Why not!");

        private String words;

        NEUTRAL(String words) {
            this.words = words;
        }

        public String getWords() {
            return words;
        }
    }
    public enum HAPPY{
        A ("Hello!!"),
        B   ("Doing great!!"),
        C   ("Always!!");

        private String words;

        HAPPY(String words) {
            this.words = words;
        }

        public String getWords() {
            return words;
        }
    }
}

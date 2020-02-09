package game.core.enums.speech;

//Speech options for Normal Personality

public class NormalSpeech{
    public enum DEAD{
        A ("DEAD"),
        B   ("DEAD"),
        C   ("DEAD");

        private final String e_name;

        DEAD(String name)
        { this.e_name = name; }

        public String getName() { return e_name; }
    }
    public enum SAD{
        A ("*Cries* Hi..."),
        B   ("Feeling sad"),
        C   ("That would be nice! *Wipes tears*");

        private final String e_name;

        SAD(String name)
        { this.e_name = name; }

        public String getName() { return e_name; }
    }
    public enum NEUTRAL{
        A ("Hi"),
        B   ("Doing ok."),
        C   ("Why not!");

        private final String e_name;

        NEUTRAL(String name)
        { this.e_name = name; }

        public String getName() { return e_name; }
    }
    public enum HAPPY{
        A ("Hello!!"),
        B   ("Doing great!!"),
        C   ("Always!!");

        private final String e_name;

        HAPPY(String name)
        { this.e_name = name; }

        public String getName() { return e_name; }
    }
}

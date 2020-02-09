package game.core.enums.speech;//Speech options for Normal Personality


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
    // TODO: 2/6/2020 Create different speech for each mood Normal Personality
    public enum SAD{
        A ("DEAD"),
        B   ("DEAD"),
        C   ("DEAD");

        private final String e_name;

        SAD(String name)
        { this.e_name = name; }

        public String getName() { return e_name; }
    }
    public enum NEUTRAL{
        A ("DEAD"),
        B   ("DEAD"),
        C   ("DEAD");

        private final String e_name;

        NEUTRAL(String name)
        { this.e_name = name; }

        public String getName() { return e_name; }
    }
    public enum HAPPY{
        A ("DEAD"),
        B   ("DEAD"),
        C   ("DEAD");

        private final String e_name;

        HAPPY(String name)
        { this.e_name = name; }

        public String getName() { return e_name; }
    }
}

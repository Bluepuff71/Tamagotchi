package game.core.enums.speech;

public enum PlayerSpeechOptions {
    A("Hello"), B("How are you?"), C("Want to play?");

    private String words;

    PlayerSpeechOptions(String words) {
            this.words = words;
        }

        public String getWords() {
            return words;
        }
    }



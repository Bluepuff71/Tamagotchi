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


// System.out.println(PlayerSpeechOptions.A.getWords()); <-How to access string in A
// System.out.println(PlayerSpeechOptions.B.getWords()); <-How to access string in B
// System.out.println(PlayerSpeechOptions.C.getWords()); <-How to access string in C
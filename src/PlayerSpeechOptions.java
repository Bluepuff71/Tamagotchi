public enum PlayerSpeechOptions{
    A("Hello"),
    B("How are you?"),
    C("Want to play?");

    private String words;

    Environment(String words) {
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
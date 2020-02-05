public enum TamagotchiSpeechOptions{
    NNA("Ughh"),
    NA("HI"),
    NNB("Ughhh mehhh"),
    NB("Good, Thanks!"),
    NNC("Not with you"),
    NC("Of course!");


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
for(TamagotchiSpeechOptions speech : TamagotchiSpeechOptions.values())
{
    System.out.println(speech.name() + " :: "+ speech.getWords());
}
 */
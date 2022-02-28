package sentences;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {

        String longSentence = sentence;

        if (isSentenceOk(sentence)) {
            String[] words = sentence.split(" ");

            if (words.length >= 5) {
                longSentence = words[0] + " ... " + words[words.length-1];
            }
        }
        return longSentence;
    }

    private boolean isSentenceOk(String sentence) {
        char firstChar = sentence.charAt(0);
        char lastChar = sentence.charAt(sentence.length()-1);

        if (firstChar < 'A' || firstChar > 'Z')
            throw new IllegalArgumentException("Must start with capital letter!");

        if (lastChar != '.' && lastChar != '!' && lastChar != '?')
            throw new IllegalArgumentException("Must end with . ! or ?");

        return true;
    }

}
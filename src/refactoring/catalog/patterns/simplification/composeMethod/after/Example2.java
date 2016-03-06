package refactoring.catalog.patterns.simplification.composeMethod.after;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdrozdz
 * Compose Method
 */
public class Example2 {
    private static final int MAX_LINE_WIDTH = 16;

    public static List<String> wrap(StringBuilder cardText) {
        List<String> wrapLines = new ArrayList<String>();
        while (cardText.length() > 0)
            wrapLines.add(extractPhraseFrom(cardText));
        return wrapLines;
    }

    private static String extractPhraseFrom(StringBuilder cardText) {
        StringBuilder phrase = new StringBuilder("");
        StringBuilder word = new StringBuilder("");
        final int MAXCHARS = Math.min(MAX_LINE_WIDTH, cardText.length());
        for (int i = 0; i < MAXCHARS; i++) {
            addCharacterTo(word, cardText.charAt(i));
            if (isCompleteWord(word, cardText))
                addCompleteWordTo(phrase, word);
        }
        addRemainingWordTo(phrase, word);
        removePhraseFrom(cardText, phrase);
        return phrase.toString();
    }

    private static boolean isCompleteWord(StringBuilder word, StringBuilder cardText) {
        return (word.charAt(word.length() - 1) == ' ' || word.charAt(word.length() - 1) == '-' ||
                cardText.toString().endsWith(word.toString()));
    }

    private static void addCompleteWordTo(StringBuilder phrase, StringBuilder word) {
        phrase.append(word);
        word.delete(0, word.length());
    }

    private static void addRemainingWordTo(StringBuilder phrase, StringBuilder word) {
        if (phrase.length() == 0)
            phrase.append(word + "-");
    }

    private static void addCharacterTo(StringBuilder word, char character) {
        word.append(character);
    }

    private static void removePhraseFrom(StringBuilder cardText, StringBuilder phrase) {
        cardText.delete(0, phrase.length());
    }


}

package be.jorenfabre.sixletterwordchallenge;

import be.jorenfabre.sixletterwordchallenge.utilities.CombinationHandler;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    @Getter
    private static final List<Combination> output = new ArrayList<>();

    @Getter
    private final String word;
    @Getter
    private final List<String> parts;
    @Getter
    private boolean isComplete;

    public Combination(String word) {
        this.word = word;
        this.parts = new ArrayList<>();
        this.isComplete = false;

        output.add(this);
    }
    private Combination(String word, List<String> parts, String addPart) {
        this.word = word;
        this.parts = parts;
        this.addPart(addPart);
//        this.completeWord();
    }

    public void addPart(String part) {
        if (isComplete) return;
        String result = String.join("", parts) + part;
        if (word.startsWith(result)) this.parts.add(part);
        if (word.equals(result)) isComplete = true;
    }

    public void completeWord() {
        List<String> correctParts = new ArrayList<>();
        for (String part : CombinationHandler.getLtSixLetters()) {
            if (word.substring(String.join("", parts).length()).startsWith(part)) correctParts.add(part);
        }
        if (correctParts.size() == 0) output.remove(this);
        else addPart(correctParts.get(0));
        if (correctParts.size() > 1) {
            for (int i = 1; i < correctParts.size(); i++) {
                this.copy(correctParts.get(i));
            }
        }
        if (!isComplete) completeWord();
    }

    private void copy(String part) {
        new Combination(word, parts, part);
    }

    @Override
    public String toString() {
        return String.format((isComplete ? "%s=%s" : "%s is the start of %s"), String.join("+", parts), word);
    }
}

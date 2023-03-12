package be.jorenfabre.sixletterwordchallenge.utilities;

import be.jorenfabre.sixletterwordchallenge.Combination;
import be.jorenfabre.sixletterwordchallenge.Main;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CombinationHandler {

    @Getter
    private static List<String> ltSixLetters;

    public CombinationHandler(List<String> input) {
        ltSixLetters = new ArrayList<>();

        List<String> sixLetters = new ArrayList<>();
        input.forEach(word -> (word.length() < 6 ? ltSixLetters : sixLetters).add(word));

        sixLetters.forEach(this::searchWord);
        new ArrayList<>(Combination.getOutput()).forEach(Combination::completeWord);
    }

    private void searchWord(String query) {
        searchStart(query).forEach(word -> new Combination(query).addPart(word));
    }
    private List<String> searchStart(String query) {
        List<String> correctStarts = new ArrayList<>();
        for (String start : ltSixLetters) {
            if (query.startsWith(start)) correctStarts.add(start);
        }
        return correctStarts;
    }
}

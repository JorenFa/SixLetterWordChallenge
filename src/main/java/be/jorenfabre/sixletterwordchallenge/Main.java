package be.jorenfabre.sixletterwordchallenge;

import be.jorenfabre.sixletterwordchallenge.utilities.CombinationHandler;
import be.jorenfabre.sixletterwordchallenge.utilities.FileReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Main(args);
    }

    public Main(String[] args) {
        List<String> input = FileReader.read(args.length >= 1 ? args[0] : "input.txt");
        if (input == null) {
            System.out.println("File not found!");
            return;
        }

        List<String> filtered = new ArrayList<>();

        for (String str : input)
            if (!filtered.contains(str))
                filtered.add(str);

        filtered.sort(Comparator.naturalOrder());

        new CombinationHandler(filtered);

        Combination.getOutput().forEach(System.out::println);
    }
}

package functionalIface;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CharFilter {

    static final Predicate<String> startsWithB = s -> s.startsWith("B");

    static final Function<String, Predicate<String>> startsWith = start -> str -> str
            .startsWith(start);

    public static void main(String[] args) {

        List<String> names = List.of("Bob", "John", "Steve", "Johan",
                "Jill", "Bert");

        System.out.println("Starts with 'B'");
        names.stream().filter(startsWithB).forEach(System.out::println);

        System.out.println("Starts with 'Jo'");
        names.stream().filter(startsWith.apply("Jo"))
                .forEach(System.out::println);

        System.out.println("Starts with 'B' or 'J'");
        names.stream().filter(startsWithB.or(s -> s.startsWith("J")))
                .forEach(System.out::println);

        System.out.println("Starts with other than 'B' or 'J'");
        names.stream()
                .filter(startsWithB.or(s -> s.startsWith("J")).negate())
                .forEach(System.out::println);

    }
}
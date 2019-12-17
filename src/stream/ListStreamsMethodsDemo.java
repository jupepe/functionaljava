package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStreamsMethodsDemo {

    public static void printMap() {
        Stream.of(1, 2, 3, 4, 5).map(n -> n * 2)
                .forEach(System.out::println);
    }

    public static void printFlatMap() {
        List<String> list1 = List.of("one", "two", "three");
        List<String> list2 = List.of("uno", "due", "tre");
        List<String> list3 = List.of("un", "deux", "trois");

        Stream.of(list1, list2, list3).flatMap(List::stream)
                .forEach(System.out::println);
    }

    public static void filterList() {
        Stream.of(1, 2, 3, 4, 5).filter(n -> n > 2)
                .forEach(System.out::println);
    }

    public static void negateFilterList() {
        Predicate<Integer> greaterThan2 = n -> n > 2;
        Stream.of(1, 2, 3, 4, 5).filter(greaterThan2.negate())
                .forEach(System.out::println);
    }

    public static void filterNulls() {
        Stream.of(1, 2, null, null, 5).filter(Objects::nonNull)
                .map(n -> Math.pow(n, 3)).forEach(System.out::println);
        Stream.of(1, 2, null, null, 5).filter(n -> n != null)
                .map(n -> Math.pow(n, 3)).forEach(System.out::println);
        // Stream.of(1, 2, null, null, 5).map(n -> Math.pow(n,
        // 3)).forEach(System.out::println); // NullPointerException
    }

    public static void joinToList() {
        List<String> zeroes = Stream.of("one", "uno", "un", "nolla")
                .collect(Collectors.toList());
        System.out.println(zeroes);
    }

    public static void joinToString() {
        String zeroes = Stream.of("one", "uno", "un", "nolla")
                .collect(Collectors.joining(", "));
        System.out.println(zeroes);
    }

    public static void sortList() {
        Stream.of("one", "uno", "un", "nolla")
                .sorted((a, b) -> a.compareTo(b))
                .forEach(System.out::println);
    }

    public static void reverseSortList() {
        Comparator<String> comparator = (a, b) -> a.compareTo(b);

        Stream.of("one", "uno", "un", "nolla").sorted(comparator.reversed())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("Mapping");
        printMap();
        printFlatMap();

        System.out.println("Filtering");
        filterList();
        negateFilterList();
        filterNulls();

        System.out.println("Joining");
        joinToList();
        joinToString();

        System.out.println("Sorting");
        sortList();
        reverseSortList();
    }

}

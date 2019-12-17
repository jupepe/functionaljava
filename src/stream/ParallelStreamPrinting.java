package stream;

import java.util.List;

public class ParallelStreamPrinting {
    public static void main(String[] args) {
        List<String> list = List.of("D", "E", "C", "B", "A", "F", "D", "B",
                "A");

        System.out.println(
                "parallelStream: forEach - ordered and distinct set of items");
        list.parallelStream() // do parallel processing
                .distinct() // remove duplicates
                .sorted().forEach(System.out::println);

        System.out.println(
                "parallelStream: forEach - printed in sequential processing order");
        list.parallelStream() // do sequential processing
                .distinct() // remove duplicates
                .sorted().sequential() // change the order before printing items
                .forEach(System.out::println);

        System.out.println(
                "parallelStream: forEachOrdered - ordered and distinct set of items");

        list.parallelStream() // do parallel processing
                .distinct().sorted().forEachOrdered(System.out::println);

    }
}

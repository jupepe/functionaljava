package stream;

import java.util.Comparator;
import java.util.List;

public class ParallelIntegerListPrinting {
    public static void main(String[] args) {

        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Original list");
        intList.stream().forEach(i -> System.out.print(i + " "));
        System.out.println("");

        System.out.println("List is sorted in reverse order");
        Comparator<Integer> normal = Integer::compare;
        intList.stream().sorted(normal.reversed())
                .forEach(i -> System.out.print(i + " "));
        System.out.println("");

        System.out.println("Parallel stream is printed 5 times");
        for (int k = 0; k < 5; k++) {
            intList.parallelStream().sorted(normal.reversed())
                    .forEach(i -> System.out.print(i + " "));
            System.out.println("");
        }

        System.out.println("Ordered Parallel stream");
        intList.parallelStream().sorted(normal.reversed())
                .forEachOrdered(i -> System.out.print(i + " "));
        System.out.println("");

    }
}

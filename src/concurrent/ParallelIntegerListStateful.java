package concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelIntegerListStateful {
    public static void main(String[] args) {

        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12);

        // Try Lambda expressions which has state
        try {

            List<Integer> copyOfIntList = new ArrayList<>();

            System.out.println("Normal stream:");
            intList.stream().map(i -> {
                copyOfIntList.add(i);
                return i;
            }).forEachOrdered(i -> System.out.print(i + " "));
            System.out.println("");

            copyOfIntList.stream()
                    .forEachOrdered(i -> System.out.print(i + " "));
            System.out.println("");

            System.out.println("Parallel stream:");

            System.out.println("List created from parallelStream:");
            for (int k = 0; k < 5; k++) {
                List<Integer> parallelStorage = Collections
                        .synchronizedList(new ArrayList<>());
                intList.parallelStream().map(i -> {
                    parallelStorage.add(i);
                    return i;
                }).forEach(i -> System.out.print(i + " "));
                System.out.print(" -> ");
                
                parallelStorage.parallelStream()
                        .forEachOrdered(i -> System.out.print(i + " "));

                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // Create Double List with Stateless lambda expressions
        List<Double> newDoubleList = intList.parallelStream()
                .map(e -> (double) e).sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("New Collection created with stateless lambdas");
        newDoubleList.stream().forEach(e -> System.out.print(e + " "));
        System.out.println("");

    }
}

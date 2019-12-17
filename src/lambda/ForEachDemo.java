package lambda;

import java.util.List;
import java.util.function.Predicate;

public class ForEachDemo {

    public static void main(String[] args) {
        
        List<Integer> numbers = List.of( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );

        System.out.println(
                "sqrt for filtered even numbers with traditional for:");
        for (Integer i : numbers) {
            if (i % 2 == 0) {
                System.out.print(i + "=>" + i * i + ", ");
            }
        }

        System.out.println();

        System.out.println(
                "sqrt for filtered even numbers with lambda forEach:");

        Predicate<Integer> evenTest = i -> i % 2 == 0; 
        numbers.stream().filter(evenTest)
                .forEach(i -> System.out.print(i + "=>" + i * i + ", "));
        System.out.println();

        System.out.println("sqrt for filtered odd numbers with map:");

        numbers.stream().filter(i -> i % 2 != 0).map(i -> i * i)
                .forEach(i -> System.out.print(i + ", "));

        System.out.println();

    }
}

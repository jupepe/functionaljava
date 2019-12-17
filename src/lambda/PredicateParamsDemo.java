package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.Objects;
import java.util.OptionalDouble;

public class PredicateParamsDemo {

    public static int filteredSum(List<Integer> numbers,
            Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(predicate)
                .mapToInt(i -> i.intValue()).sum();
    }
    
    public static OptionalDouble filteredAverage(List<Integer> numbers,
            Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(predicate)
                .mapToInt(i -> i)
                .average();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 1, 2, 3, 4, 5, 40, 50,
                null);
        System.out.println(filteredSum(numbers, n -> true));
        System.out.println(filteredSum(numbers, n -> n % 2 == 1));
        System.out.println(filteredSum(numbers, n -> n % 2 == 0));
        System.out.println(filteredSum(numbers, n -> n >= 20));
        
        System.out.println("Averages:");
        System.out.println(filteredAverage(numbers, n -> true).getAsDouble());
        System.out.println(filteredAverage(numbers, n -> n % 2 == 1).getAsDouble());
        System.out.println(filteredAverage(numbers, n -> n % 2 == 0).getAsDouble());        
        System.out.println(filteredAverage(numbers, n -> n >= 20).getAsDouble());
    }

}


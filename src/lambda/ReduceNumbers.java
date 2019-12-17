package lambda;

import java.util.List;

public class ReduceNumbers {

    public static void main(String args[]) {

        List<Double> numbers = List.of(12.5,22.4,9.3,31.4,20.0, 4.5);
        Double max = numbers.stream().reduce(Double.MIN_VALUE, Double::max);
        Double res = numbers.stream().reduce(1.0,
                (n1, n2) -> n1 * n2);
        Double sum = numbers.stream().reduce(0.0, (n1, n2) -> n1 + n2);

        System.out.println("max: " + max);
        System.out.println("mult:" + res);
        System.out.println("sum: " + sum);

    }
}

package lambda;

import java.util.function.BinaryOperator;
import java.util.function.BiFunction;

public class LambdaNumbersDemo {

    public static void main(String[] args) {
        System.out.println("Lambda examples: ");

        BinaryOperator<Integer> sumOrMultiply = (a, b) -> {
            if (a > b) {
                return a + b;
            } else {
                return a * b;
            }
        };

        BiFunction<Integer, Integer, String> concatNumbers = (a,
                b) -> "Concat:" + a + b;

        int sum = sumOrMultiply.apply(30, 20);
        int multiply = sumOrMultiply.apply(10, 12);
        String result = concatNumbers.apply(30, 25);

        System.out.println("sumOrMultiply(30,20): " + sum);
        System.out.println("sumOrMultiply(10,12): " + multiply);
        System.out.println(result);

    }
}

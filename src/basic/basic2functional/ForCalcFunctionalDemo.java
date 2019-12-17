package basic.basic2functional;

import java.util.stream.IntStream;

public class ForCalcFunctionalDemo {

    public static int sum(int begin, int end) {
        return IntStream.rangeClosed(begin, end).reduce((a, b) -> a + b)
                .getAsInt();
    }

    public static int multiply(int begin, int end) {
        return IntStream.rangeClosed(begin, end).reduce((Integer) 1,
                (a, b) -> a * b);
    }

    public static void main(String args[]) {

        int sum = sum(1, 10);
        int res = multiply(1, 10);

        System.out.println("sum 1-10 = " + sum);
        System.out.println("multiply 1-10 = " + res);

    }
}

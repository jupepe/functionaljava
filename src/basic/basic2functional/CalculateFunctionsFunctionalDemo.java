package basic.basic2functional;

import java.util.stream.IntStream;

public class CalculateFunctionsFunctionalDemo {

    // static final variables to define LOWER and UPPER limits
    static final int LOWER = 1, UPPER = 10;

    public static void calculateAndPrintValues() {
        IntStream.rangeClosed(LOWER, UPPER).forEach(i -> {
            IntStream.rangeClosed(LOWER, UPPER)
                    .forEach(k -> System.out.print((i * k) + "\t"));
            System.out.println();
        });
    }

    public static void main(String argv[]) {
        calculateAndPrintValues();

    }
}

package stream;

import java.util.stream.IntStream;

public class ParallelModeDemo {

    public static void printThreadName(IntStream vals) {

        System.out.println("Normal Mode");

        vals.forEach(x -> {
            System.out.println("Thread : "
                    + Thread.currentThread().getName() + ", value: " + x);
        });

    }

    public static void printThreadNameParallel(IntStream vals) {

        System.out.println("Parallel Mode");

        vals.parallel().forEach(x -> {
            System.out.println("Thread : "
                    + Thread.currentThread().getName() + ", value: " + x);
        });

    }

    public static void printThreadNameParallelOrdered(IntStream vals) {

        System.out.println("Parallel Mode in forEachOrdered");

        vals.parallel().forEachOrdered(x -> {
            System.out.println("Thread : "
                    + Thread.currentThread().getName() + ", value: " + x);
        });

    }
    
    
    public static void printMode(IntStream vals, IntStream vals2) {

        System.out.println("Normal Mode");

        System.out.println(vals.isParallel());
        vals.forEach(System.out::println);

        System.out.println("Parallel Mode");

        vals2.parallel();
        System.out.println(vals2.isParallel());
        vals.forEach(System.out::println);

    }

    public static void main(String args[]) {
        IntStream vals = IntStream.rangeClosed(1, 10);
        printThreadName(vals);
        vals = IntStream.rangeClosed(1, 10);
        printThreadNameParallel(vals);
        vals = IntStream.rangeClosed(1, 10);
        printThreadNameParallelOrdered(vals);

    }

}

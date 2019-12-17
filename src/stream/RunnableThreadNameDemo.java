package stream;

import java.util.ArrayList;
import java.util.List;

public class RunnableThreadNameDemo {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        Runnable r = () -> {
            numbers.forEach(i -> {
                System.out.println("Thread : "
                        + Thread.currentThread().getName() + ", value: " + i*10);
            });
        };
        Thread th = new Thread(r);
        //th.start();

        Thread th2 = new Thread(() -> {
            numbers.parallelStream().forEach(i -> {
                System.out.println("Thread : "
                        + Thread.currentThread().getName() + ", value: " + i*2);
            });
        });
        th2.start();
        th.start();

    }
}


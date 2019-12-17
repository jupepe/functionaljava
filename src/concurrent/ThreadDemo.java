package concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {

    public static void main(String[] args) {
        run1();
        run2();
    }

    public static void run1() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Running the Thread " + threadName);
        };
        
        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("run1 end!");
    }

    public static void run2() {
        Runnable runnable = () -> {
            try {
                System.out.println("Starting 2nd Thread  "
                        + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("2nd Second Output "
                        + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        System.out.println("run2 end!");

    }

}

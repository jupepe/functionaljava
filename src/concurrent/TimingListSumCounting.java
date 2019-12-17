package concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TimingListSumCounting {
    public final static int max = 20000000; 

    public static long iteration() {
        long res = 0;
        for (long i = 0; i <= max; i++)
            res = res + i;
        return res;
    }

    public static long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1).limit(max).reduce(Long::sum)
                .get();
    }

    public static long parallelSum() {
        return Stream.iterate(1L, i -> i + 1).parallel().limit(max)
                .reduce(Long::sum).get();
    }

    public static long rangedSequentialSum() {
        return LongStream.rangeClosed(1L, max).reduce(Long::sum)
                .getAsLong();
    }

    public static long rangedParallelSum() {
        return LongStream.rangeClosed(1L, max).parallel().reduce(Long::sum)
                .getAsLong();
    }

    public static long longSummaryStatsSum() {
        return LongStream.rangeClosed(1L, max).sum();
    }

    // käyttää lisäämiseen säieturvallista LongAdder -oliota
    public static Long runnableSum(int start, int end) {
        LongAdder adder = new LongAdder();
        IntStream.rangeClosed(start, end).forEach(adder::add);
        System.out.println("subtaski jossa alku " + start
                + "\t on valmis: nyt summa " + adder.longValue());
        return adder.longValue();
    }

    // Käyttää laskemiseen neljää asynkronista (CompletableFuture) metodia
    public static long longAdder() {
        // LongAdder adder = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CompletableFuture<Long> f1 = CompletableFuture.supplyAsync(
                () -> runnableSum(0, max / 4), executorService);
        CompletableFuture<Long> f2 = CompletableFuture.supplyAsync(
                () -> runnableSum(max / 4 + 1, max / 2), executorService);
        CompletableFuture<Long> f3 = CompletableFuture.supplyAsync(
                () -> runnableSum(max / 2 + 1, max / 4 * 3),
                executorService);
        CompletableFuture<Long> f4 = CompletableFuture.supplyAsync(
                () -> runnableSum(max / 4 * 3 + 1, max), executorService);

        // Odotetaan, kunnes kaikki alitaskit on valmistuneet
        CompletableFuture<Void> futuresAll = CompletableFuture.allOf(f1, f2,
                f3, f4);
        System.out.println("Odotellaan Future-taskien valmistumista");
        long totalSum = 0L;
        try {
            // Odotellaan kaikkien subtaskien valmistumista
            futuresAll.get();
            totalSum = f1.get() + f2.get() + f3.get() + f4.get();
            System.out.println("Kaikki CompletableFuture:t valmiita!");
        } catch (InterruptedException | ExecutionException e) {
        }

        return totalSum;
    }

    /* Suoritettava funktio parametrinä Supplier-oliona */
    public static void calculateTime(Supplier<Long> function,
            String funcName) {
        long startTime = System.currentTimeMillis();
        long sum = function.get();
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Time for " + funcName + ": " + endTime
                + " and sum " + sum);
    }

    public static void main(String[] args) {
        // Suoritettava funktio lähetetään parametrinä!
        calculateTime(TimingListSumCounting::iteration, "iterative sum");
        // tehottamia metodeita - ei kannata ottaa vertailuun mukaan
        calculateTime(TimingListSumCounting::sequentialSum,
                "sequential iterative sum");
        calculateTime(TimingListSumCounting::parallelSum,
                "parallel iterative sum");
        calculateTime(TimingListSumCounting::rangedSequentialSum,
                "ranged sequential sum");
        calculateTime(TimingListSumCounting::rangedParallelSum,
                "ranged parallel sum");
        calculateTime(TimingListSumCounting::longSummaryStatsSum,
                "longSummary sum");
        calculateTime(TimingListSumCounting::longAdder, "longAdder sum");

    }
}

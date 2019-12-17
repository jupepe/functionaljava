package concurrent;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureDemo1 {

    private static String formatDouble(Integer value1, Double result) {
        return String.format("%d*%d*PI=%.2f", value1, value1, result);
    }

    @SuppressWarnings("unused")
    private <E> CompletableFuture<List<E>> collectTasks(
            final List<CompletableFuture<E>> futures) {
        final CompletableFuture<Void> futuresCompleted = CompletableFuture
                .allOf(futures
                        .toArray(new CompletableFuture[futures.size()]));
        return futuresCompleted.thenApply(
                v -> futures.stream().map(CompletableFuture<E>::join)
                        .collect(Collectors.<E>toList()));
    }

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = new CompletableFuture<>();

        // safe approach
        CompletableFuture<Integer> future2 = future1.handle((ok, ex) -> {
            if (ok != null) {
                return Integer.parseInt(ok);
            } else {
                System.out.println("Error in parsing" + ex);
                return -1;
            }
        });

        // CompletableFuture<Integer> future2 = future1.thenApply(Integer::parseInt);
        CompletableFuture<Double> future3 = future2
                .thenApply(r -> r * r * Math.PI);

        future3.thenAccept(System.out::print).thenAccept(
                f -> System.out.println(" - future3 completed."));
        future2.thenAccept(System.out::print).thenAccept(
                f -> System.out.println(" - future2 completed."));
        future1.thenAccept(System.out::print).thenAccept(
                f -> System.out.println(" - future1 completed."));

        // When combining futures, then all combined futures should be are completed
        CompletableFuture<String> combinedFuture = future2
                .thenCombine(future3, (f2, f3) -> formatDouble(f2, f3));
        combinedFuture.thenAccept(System.out::print).thenAccept(
                f -> System.out.println(" - combinedFuture completed."));

        future1.complete("21");
    }

}

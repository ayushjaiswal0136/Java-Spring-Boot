package Day12;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

    private static long sumUpTo(long n) {
        long total = 0;
        for (long i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) throws Exception {

        // ExecutorService is AutoCloseable: try-with-resources (Day 8) waits for
        // the submitted tasks, then shuts the pool down
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {

            // 1. One task: do other work while it runs, then collect the result
            Future<String> report = executor.submit(() -> {
                Thread.sleep(200);
                return "Report ready";
            });
            System.out.println("Main keeps working...");
            System.out.println("Result: " + report.get());       // waits if not finished yet

            // 2. Many tasks: results come back in the order of the list
            List<Callable<Long>> jobs = List.of(
                    () -> sumUpTo(100),
                    () -> sumUpTo(1_000),
                    () -> sumUpTo(1_000_000));
            for (Future<Long> future : executor.invokeAll(jobs)) {
                System.out.println("Sum: " + future.get());
            }

            // 3. A task that fails: the exception arrives wrapped in ExecutionException
            Future<Integer> failing = executor.submit(() -> Integer.parseInt("abc"));
            try {
                failing.get();
            } catch (ExecutionException e) {
                System.out.println("Task failed: " + e.getCause().getClass().getSimpleName()
                        + " -> " + e.getCause().getMessage());
            }
        }
    }
}
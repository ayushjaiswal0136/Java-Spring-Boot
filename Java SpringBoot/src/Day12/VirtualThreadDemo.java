package Day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread virtual = Thread.ofVirtual().name("virtual-1").start(
                () -> System.out.println("Is virtual: " + Thread.currentThread().isVirtual()));
        virtual.join();

        AtomicInteger completed = new AtomicInteger();
        long begin = System.currentTimeMillis();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000; i++) {
                executor.submit(() -> {
                    Thread.sleep(100);               // pretend to wait for a database
                    completed.incrementAndGet();
                    return null;
                });
            }
        }                                            // close() waits for all 1,000 tasks

        long elapsed = System.currentTimeMillis() - begin;
        System.out.println("Completed: " + completed.get());
        System.out.println("Took about " + elapsed + " ms (one after another would be 100,000 ms)");
    }
}
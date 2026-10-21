package Day12;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionDemo {

    static class UnsafeCounter {
        private int count = 0;
        public void increment() { count++; }          // read, add, write: three steps
        public int get() { return count; }
    }

    static class SynchronizedCounter {
        private int count = 0;
        public synchronized void increment() { count++; }
        public synchronized int get() { return count; }
    }

    private static void runInTwoThreads(Runnable work) throws InterruptedException {
        Thread first = new Thread(work);
        Thread second = new Thread(work);
        first.start();
        second.start();
        first.join();
        second.join();
    }

    public static void main(String[] args) throws InterruptedException {
        int loops = 100_000;

        UnsafeCounter unsafe = new UnsafeCounter();
        runInTwoThreads(() -> {
            for (int i = 0; i < loops; i++) {
                unsafe.increment();
            }
        });
        System.out.println("Unsafe: " + unsafe.get() + " (expected 200000)");

        SynchronizedCounter synced = new SynchronizedCounter();
        runInTwoThreads(() -> {
            for (int i = 0; i < loops; i++) {
                synced.increment();
            }
        });
        System.out.println("Synchronized: " + synced.get());

        AtomicInteger atomic = new AtomicInteger();
        runInTwoThreads(() -> {
            for (int i = 0; i < loops; i++) {
                atomic.incrementAndGet();
            }
        });
        System.out.println("Atomic: " + atomic.get());
    }
}
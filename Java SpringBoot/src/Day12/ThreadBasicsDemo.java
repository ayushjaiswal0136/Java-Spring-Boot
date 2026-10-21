package Day12;

public class ThreadBasicsDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running in: " + Thread.currentThread().getName());

        Runnable task = () ->
                System.out.println("Task running in: " + Thread.currentThread().getName());

        // run() is just a normal method call: it executes in the CURRENT thread
        Thread direct = new Thread(task, "worker-A");
        direct.run();

        // start() creates a real new thread and runs the task there
        Thread started = new Thread(task, "worker-B");
        started.start();
        started.join();                      // wait until worker-B finishes

        // Two threads working at the same time; main waits for both
        Thread email = new Thread(() -> System.out.println("Sending email..."), "email-thread");
        Thread audit = new Thread(() -> System.out.println("Writing audit log..."), "audit-thread");
        email.start();
        audit.start();
        email.join();
        audit.join();
        System.out.println("Both finished");

        long begin = System.currentTimeMillis();
        Thread.sleep(300);                   // pauses ONLY the current thread
        long elapsed = System.currentTimeMillis() - begin;
        System.out.println("Slept about " + elapsed + " ms");
    }
}
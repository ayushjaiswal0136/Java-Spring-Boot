package Day9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {

        // Queue: first in, first out
        Queue<String> jobs = new ArrayDeque<>();
        jobs.offer("Task A");
        jobs.offer("Task B");
        jobs.offer("Task C");

        System.out.println("Next: " + jobs.peek());          // look, don't remove
        System.out.println("Processing: " + jobs.poll());    // remove from front
        System.out.println("Processing: " + jobs.poll());
        System.out.println("Remaining: " + jobs);

        // Stack: last in, first out (browser back button)
        Deque<String> history = new ArrayDeque<>();
        history.push("page1");
        history.push("page2");
        history.push("page3");

        System.out.println("Back from: " + history.pop());
        System.out.println("Now on: " + history.peek());

        Queue<String> empty = new ArrayDeque<>();
        System.out.println("Empty poll returns: " + empty.poll());
    }
}
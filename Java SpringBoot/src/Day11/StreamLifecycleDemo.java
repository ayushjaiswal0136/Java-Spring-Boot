package Day11;

import java.util.stream.Stream;

public class StreamLifecycleDemo {
    public static void main(String[] args) {

        // 1. Lazy: no terminal operation, so nothing runs
        Stream.of("a", "bb", "ccc")
                .peek(s -> System.out.println("never printed: " + s))
                .filter(s -> s.length() > 1);
        System.out.println("Pipeline built, nothing ran");

        // 2. Items flow one at a time, and the stream stops early (short-circuit)
        Stream.of("a", "bb", "ccc", "dd")
                .peek(s -> System.out.println("check " + s))
                .filter(s -> s.length() >= 2)
                .peek(s -> System.out.println("passed " + s))
                .findFirst();

        // 3. A stream can be consumed only once
        Stream<String> stream = Stream.of("x", "y");
        stream.forEach(System.out::println);
        try {
            stream.forEach(System.out::println);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
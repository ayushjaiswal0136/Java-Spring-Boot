package Day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class InputOutputDemo {

    public static void main(String[] args) throws IOException {

        // 1. Console input: type in the Run panel of IntelliJ
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            System.out.println("Hello " + name + ", next year you will be " + (age + 1));
        }

        // 2. Files: write, read, check, delete
        Path file = Path.of("tasks.txt");              // created in your project folder
        Files.write(file, List.of("Design API", "Write tests", "Fix bug"));

        List<String> lines = Files.readAllLines(file);
        System.out.println("Read " + lines.size() + " lines: " + lines);
        System.out.println("Exists: " + Files.exists(file));

        Files.delete(file);
        System.out.println("Exists after delete: " + Files.exists(file));
    }
}
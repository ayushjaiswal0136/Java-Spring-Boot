package Day11;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "Engineering", 75000),
                new Employee(3, "Carol", "HR", 50000),
                new Employee(4, "Dave", "Sales", 60000),
                new Employee(5, "Eve", "Engineering", 120000),
                new Employee(6, "Frank", "Sales", 45000),
                new Employee(7, "Grace", "HR", 55000));

        // filter + map
        List<String> engineers = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering"))
                .map(Employee::getName)
                .toList();
        System.out.println("Engineers: " + engineers);

        // sort + limit
        List<String> top3 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getName)
                .toList();
        System.out.println("Top 3 paid: " + top3);

        // numbers
        double total = employees.stream().mapToDouble(Employee::getSalary).sum();
        double average = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println("Total salary: " + total);
        System.out.printf("Average salary: %.2f%n", average);

        // max returns an Optional
        employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(e -> System.out.println("Highest paid: " + e));

        // groupingBy (TreeMap keeps the keys sorted so the output is predictable)
        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, TreeMap::new, Collectors.toList()));
        System.out.println("By department: " + byDepartment);

        Map<String, Long> countByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, TreeMap::new, Collectors.counting()));
        System.out.println("Count by department: " + countByDepartment);

        Map<String, Double> averageByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, TreeMap::new,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average by department: " + averageByDepartment);

        // partitioningBy: exactly two groups, true and false
        Map<Boolean, List<String>> partition = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.getSalary() >= 60000,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Salary >= 60000: " + partition);

        // toMap: build a lookup table (keys must be unique)
        Map<Integer, Employee> byId = employees.stream()
                .collect(Collectors.toMap(Employee::getId, e -> e));
        System.out.println("Employee 3: " + byId.get(3));

        // joining
        String names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Names: " + names);

        // summary statistics
        DoubleSummaryStatistics stats = employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println("Min: " + stats.getMin() + ", Max: " + stats.getMax()
                + ", Count: " + stats.getCount());

        // Entity -> DTO mapping: the most common real-world use of map()
        List<EmployeeDto> dtos = employees.stream()
                .filter(e -> e.getSalary() > 80000)
                .map(e -> new EmployeeDto(e.getName(), e.getDepartment()))
                .toList();
        System.out.println("DTOs: " + dtos);
    }
}
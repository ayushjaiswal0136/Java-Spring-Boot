public class VariablesDemo {
    public static void main(String[] args) {
        // Primitive types
        int employeeId = 101;
        double salary = 55000.75;
        boolean isActive = true;
        char grade = 'A';

        // Reference type
        String employeeName = "Ayush Jaiswal";

        // var (type inference)
        var department = "Backend Engineering";

        // Printing
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Salary: " + salary);
        System.out.println("Active: " + isActive);
        System.out.println("Grade: " + grade);
        System.out.println("Department: " + department);
    }
}
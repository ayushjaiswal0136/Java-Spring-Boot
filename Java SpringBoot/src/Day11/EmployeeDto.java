package Day11;

public class EmployeeDto {

    private final String name;
    private final String department;

    public EmployeeDto(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDto{name=" + name + ", department=" + department + "}";
    }
}
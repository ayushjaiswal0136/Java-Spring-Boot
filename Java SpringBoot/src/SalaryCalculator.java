public class SalaryCalculator {

    public static void main(String[] args) {

        double baseSalary = 45000;
        int bonusPercentage = 10;

        boolean isEligibleForBonus = true;

        double bonus = 0;

        if (isEligibleForBonus) {
            bonus = baseSalary * bonusPercentage / 100;
        }

        double totalSalary = baseSalary + bonus;

        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + totalSalary);
    }
}

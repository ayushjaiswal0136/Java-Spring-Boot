public class EmployeeEvaluator {

    static boolean isEligibleForBonus(double performanceScore) {
        return performanceScore >= 75;
    }

    static double calculateBonus(double salary, double performanceScore) {
        if (isEligibleForBonus(performanceScore)) {
            return salary * 10 / 100;
        }

        return 0;
    }

    static String getPerformanceGrade(double score) {
        if (score >= 90) {
            return "Excellent";
        } else if (score >= 75) {
            return "Good";
        } else if (score >= 50) {
            return "Average";
        } else {
            return "Needs Improvement";
        }
    }

    public static void main(String[] args) {

        double[] salaries = {50000, 60000, 45000};
        double[] scores = {95, 80, 60};

        for (int i = 0; i < scores.length; i++) {

            double bonus = calculateBonus(salaries[i], scores[i]);
            String grade = getPerformanceGrade(scores[i]);

            System.out.println("Employee " + (i + 1));
            System.out.println("Salary: " + salaries[i]);
            System.out.println("Performance Score: " + scores[i]);
            System.out.println("Bonus: " + bonus);
            System.out.println("Grade: " + grade);
            System.out.println("--------------------");
        }
    }
}

package Day7;

public abstract class Report {

    public abstract String buildBody();

    public void printReport() {
        System.out.println("===== REPORT =====");
        System.out.println(buildBody());
        System.out.println("==================");
    }
}
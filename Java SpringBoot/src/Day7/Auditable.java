package Day7;

public interface Auditable {
    String getCreatedBy();

    default String describeAudit() {
        return "Task created by: " + getCreatedBy();
    }
}
package Day6;

public class FeatureTask extends Task {
    private int storyPoints;

    public FeatureTask(int id, String title, int storyPoints) {
        super(id, title); // Call the parent constructor
        this.storyPoints = storyPoints;
    }

    @Override
    public void displayTask() {
        super.displayTask(); // Display parent task details
        System.out.println("Story Points: " + storyPoints);
    }
}

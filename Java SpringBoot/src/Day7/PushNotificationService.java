package Day7;

public class PushNotificationService
        implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("[PUSH] " + message);
    }
}
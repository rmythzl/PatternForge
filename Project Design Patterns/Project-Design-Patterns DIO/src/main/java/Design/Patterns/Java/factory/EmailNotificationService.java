package Design.Patterns.Java.factory;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Enviando e-mail: " + message);
    }
}
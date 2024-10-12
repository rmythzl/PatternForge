package Design.Patterns.Java.factory;

import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {
    public NotificationService getNotificationService(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotificationService();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SmsNotificationService();
        }
        throw new IllegalArgumentException("Tipo de notificação inválido");
    }
}
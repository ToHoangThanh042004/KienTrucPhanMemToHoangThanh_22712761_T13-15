package notification.factory.method;

public class NotificationFactory {

    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        }
        return null;
    }
}

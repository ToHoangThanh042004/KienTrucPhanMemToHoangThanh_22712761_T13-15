package notification.factory.abstractfactory;

import notification.factory.method.EmailNotification;
import notification.factory.method.Notification;

public class BasicNotificationFactory implements NotificationFactoryAbstract {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

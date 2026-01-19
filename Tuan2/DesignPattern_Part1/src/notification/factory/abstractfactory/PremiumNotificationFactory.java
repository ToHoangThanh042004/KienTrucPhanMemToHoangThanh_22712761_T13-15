package notification.factory.abstractfactory;

import notification.factory.method.Notification;
import notification.factory.method.SMSNotification;

public class PremiumNotificationFactory implements NotificationFactoryAbstract {

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

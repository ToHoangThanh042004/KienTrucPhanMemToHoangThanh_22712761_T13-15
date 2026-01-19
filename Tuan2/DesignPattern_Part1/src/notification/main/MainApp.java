package notification.main;

import notification.factory.abstractfactory.NotificationFactoryAbstract;
import notification.factory.abstractfactory.PremiumNotificationFactory;
import notification.factory.method.Notification;
import notification.factory.method.NotificationFactory;
import notification.singleton.ConfigManager;

public class MainApp {

    public static void main(String[] args) {

        // Singleton
        ConfigManager config = ConfigManager.getInstance();
        System.out.println(config.getSystemName());

        // Factory Method
        Notification email = NotificationFactory.createNotification("EMAIL");
        email.send();

        // Abstract Factory
        NotificationFactoryAbstract factory = new PremiumNotificationFactory();
        Notification notification = factory.createNotification();
        notification.send();
    }
}

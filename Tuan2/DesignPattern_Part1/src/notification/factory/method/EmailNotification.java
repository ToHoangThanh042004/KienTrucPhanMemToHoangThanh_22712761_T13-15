package notification.factory.method;

public class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Gửi thông báo qua EMAIL");
    }
}

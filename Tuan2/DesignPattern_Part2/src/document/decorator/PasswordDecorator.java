package document.decorator;

public class PasswordDecorator extends DocumentDecorator {

    public PasswordDecorator(Document document) {
        super(document);
    }

    public void show() {
        document.show();
        System.out.println("Bảo vệ tài liệu bằng mật khẩu");
    }
}

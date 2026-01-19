package document.decorator;

public class WatermarkDecorator extends DocumentDecorator {

    public WatermarkDecorator(Document document) {
        super(document);
    }

    public void show() {
        document.show();
        System.out.println("Thêm watermark");
    }
}

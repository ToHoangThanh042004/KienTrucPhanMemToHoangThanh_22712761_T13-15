package order.decorator;

public class GiftWrapDecorator extends OrderDecorator {
    public GiftWrapDecorator(OrderComponent order) {
        super(order);
    }

    @Override
    public void process() {
        order.process();
        System.out.println("Thêm gói quà cho đơn hàng");
    }
}

package order.decorator;

public class InsuranceDecorator extends OrderDecorator {
    public InsuranceDecorator(OrderComponent order) {
        super(order);
    }

    @Override
    public void process() {
        order.process();
        System.out.println("Thêm bảo hiểm cho đơn hàng");
    }
}

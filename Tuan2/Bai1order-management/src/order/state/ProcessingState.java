package order.state;

import order.context.OrderContext;

public class ProcessingState implements OrderState {
    @Override
    public void handle(OrderContext order) {
        System.out.println("Đơn hàng đang xử lý: Đóng gói và vận chuyển");
        order.setState(new DeliveredState());
    }
}

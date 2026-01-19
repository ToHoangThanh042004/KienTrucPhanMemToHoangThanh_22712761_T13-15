package order.state;

import order.context.OrderContext;

public class DeliveredState implements OrderState {
    @Override
    public void handle(OrderContext order) {
        System.out.println("Đơn hàng đã giao thành công");
    }
}

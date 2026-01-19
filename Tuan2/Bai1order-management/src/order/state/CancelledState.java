package order.state;

import order.context.OrderContext;

public class CancelledState implements OrderState {
    @Override
    public void handle(OrderContext order) {
        System.out.println("Đơn hàng bị hủy và hoàn tiền");
    }
}

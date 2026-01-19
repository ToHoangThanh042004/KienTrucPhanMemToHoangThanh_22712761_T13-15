package order.state;

import order.context.OrderContext;

public class NewOrderState implements OrderState {
    @Override
    public void handle(OrderContext order) {
        System.out.println("Đơn hàng mới tạo: Kiểm tra thông tin đơn hàng");
        order.setState(new ProcessingState());
    }
}

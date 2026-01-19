package order.state;

import order.context.OrderContext;

public interface OrderState {
    void handle(OrderContext order);
}

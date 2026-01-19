package order.context;

import order.state.NewOrderState;
import order.state.OrderState;
import order.strategy.ShippingStrategy;

public class OrderContext {
    private OrderState state;
    private ShippingStrategy shippingStrategy;

    public OrderContext() {
        this.state = new NewOrderState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void setShippingStrategy(ShippingStrategy strategy) {
        this.shippingStrategy = strategy;
    }

    public void processOrder() {
        state.handle(this);
        if (shippingStrategy != null) {
            shippingStrategy.ship();
        }
    }
}

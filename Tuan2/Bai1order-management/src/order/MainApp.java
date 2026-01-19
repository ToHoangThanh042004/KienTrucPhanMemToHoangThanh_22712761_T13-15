package order;

import order.context.OrderContext;
import order.decorator.BasicOrder;
import order.decorator.GiftWrapDecorator;
import order.decorator.InsuranceDecorator;
import order.decorator.OrderComponent;
import order.strategy.ExpressShipping;

public class MainApp {
    public static void main(String[] args) {

        OrderContext order = new OrderContext();

        order.setShippingStrategy(new ExpressShipping());
        order.processOrder();
        order.processOrder();

        OrderComponent decoratedOrder =
                new InsuranceDecorator(
                    new GiftWrapDecorator(
                        new BasicOrder()));

        decoratedOrder.process();
    }
}

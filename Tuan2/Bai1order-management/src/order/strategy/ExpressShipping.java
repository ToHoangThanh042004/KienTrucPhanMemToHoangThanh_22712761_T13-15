package order.strategy;

public class ExpressShipping implements ShippingStrategy {
    @Override
    public void ship() {
        System.out.println("Giao hàng nhanh");
    }
}

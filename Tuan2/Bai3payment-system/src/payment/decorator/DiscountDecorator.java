package payment.decorator;

public class DiscountDecorator extends PaymentDecorator {

    public DiscountDecorator(PaymentComponent payment) {
        super(payment);
    }

    @Override
    public double getAmount() {
        return payment.getAmount() * 0.9;
    }
}

package payment.state;

import payment.context.PaymentContext;

public class FailedState implements PaymentState {
    @Override
    public void handle(PaymentContext payment) {
        System.out.println("Thanh toán thất bại");
    }
}

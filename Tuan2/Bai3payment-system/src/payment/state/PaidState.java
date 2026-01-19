package payment.state;

import payment.context.PaymentContext;

public class PaidState implements PaymentState {
    @Override
    public void handle(PaymentContext payment) {
        System.out.println("Thanh toán thành công");
    }
}

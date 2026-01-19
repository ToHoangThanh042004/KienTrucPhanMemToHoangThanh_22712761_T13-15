package payment.state;

import payment.context.PaymentContext;

public class UnpaidState implements PaymentState {
    @Override
    public void handle(PaymentContext payment) {
        System.out.println("Chưa thanh toán");
        payment.setState(new ProcessingState());
    }
}

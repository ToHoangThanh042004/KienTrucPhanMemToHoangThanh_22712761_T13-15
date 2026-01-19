package payment.state;

import payment.context.PaymentContext;

public interface PaymentState {
    void handle(PaymentContext payment);
}

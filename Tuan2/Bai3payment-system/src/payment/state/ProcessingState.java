package payment.state;

import payment.context.PaymentContext;

public class ProcessingState implements PaymentState {
    @Override
    public void handle(PaymentContext payment) {
        System.out.println("Đang xử lý thanh toán");
        payment.setState(new PaidState());
    }
}

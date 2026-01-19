package payment.context;

import payment.state.PaymentState;
import payment.state.UnpaidState;
import payment.strategy.PaymentStrategy;

public class PaymentContext {
    private PaymentState state;
    private PaymentStrategy strategy;

    public PaymentContext() {
        this.state = new UnpaidState();
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void process(double amount) {
        state.handle(this);
        if (strategy != null) {
            strategy.pay(amount);
        }
    }
}

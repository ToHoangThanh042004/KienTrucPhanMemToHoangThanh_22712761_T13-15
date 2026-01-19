package payment;

import payment.context.PaymentContext;
import payment.decorator.BasicPayment;
import payment.decorator.DiscountDecorator;
import payment.decorator.PaymentComponent;
import payment.decorator.ProcessingFeeDecorator;
import payment.strategy.CreditCardPayment;

public class MainApp {
    public static void main(String[] args) {

        PaymentContext payment = new PaymentContext();
        payment.setStrategy(new CreditCardPayment());

        payment.process(1000);
        payment.process(1000);

        PaymentComponent finalAmount =
                new DiscountDecorator(
                    new ProcessingFeeDecorator(
                        new BasicPayment(1000)));

        System.out.println("Số tiền phải thanh toán: " + finalAmount.getAmount());
    }
}

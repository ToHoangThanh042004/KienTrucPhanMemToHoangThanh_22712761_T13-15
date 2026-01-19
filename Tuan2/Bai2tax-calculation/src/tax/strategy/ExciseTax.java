package tax.strategy;

public class ExciseTax implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return price * 0.2;
    }
}

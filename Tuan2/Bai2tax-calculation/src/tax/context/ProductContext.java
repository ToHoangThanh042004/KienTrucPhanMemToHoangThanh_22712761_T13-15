package tax.context;

import tax.state.NoTaxState;
import tax.state.TaxState;
import tax.strategy.TaxStrategy;

public class ProductContext {
    private TaxState state;
    private TaxStrategy strategy;
    private double price;

    public ProductContext(double price) {
        this.price = price;
        this.state = new NoTaxState();
    }

    public void setState(TaxState state) {
        this.state = state;
    }

    public void setStrategy(TaxStrategy strategy) {
        this.strategy = strategy;
    }

    public void applyTax() {
        state.applyTax(this);
        if (strategy != null) {
            System.out.println("Thuế phải trả: " + strategy.calculateTax(price));
        }
    }
}

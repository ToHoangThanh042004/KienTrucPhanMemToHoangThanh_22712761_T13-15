package tax.state;

import tax.context.ProductContext;

public interface TaxState {
    void applyTax(ProductContext product);
}

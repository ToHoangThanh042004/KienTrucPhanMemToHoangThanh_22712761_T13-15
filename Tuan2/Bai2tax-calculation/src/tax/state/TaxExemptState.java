package tax.state;

import tax.context.ProductContext;

public class TaxExemptState implements TaxState {
    @Override
    public void applyTax(ProductContext product) {
        System.out.println("Sản phẩm được miễn thuế");
    }
}

package tax.state;

import tax.context.ProductContext;

public class TaxAppliedState implements TaxState {
    @Override
    public void applyTax(ProductContext product) {
        System.out.println("Sản phẩm đã được áp thuế");
    }
}

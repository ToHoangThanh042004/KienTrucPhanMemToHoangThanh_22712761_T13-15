package tax.state;

import tax.context.ProductContext;

public class NoTaxState implements TaxState {
    @Override
    public void applyTax(ProductContext product) {
        System.out.println("Sản phẩm chưa áp thuế");
        product.setState(new TaxAppliedState());
    }
}

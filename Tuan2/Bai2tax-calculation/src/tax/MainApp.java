package tax;

import tax.context.ProductContext;
import tax.decorator.BasicPrice;
import tax.decorator.LuxuryDecorator;
import tax.decorator.TaxComponent;
import tax.decorator.VATDecorator;
import tax.strategy.VATTax;

public class MainApp {
    public static void main(String[] args) {

        ProductContext product = new ProductContext(1000);
        product.setStrategy(new VATTax());
        product.applyTax();

        TaxComponent finalPrice =
                new LuxuryDecorator(
                    new VATDecorator(
                        new BasicPrice(1000)));

        System.out.println("Giá sau thuế: " + finalPrice.getTotalPrice());
    }
}

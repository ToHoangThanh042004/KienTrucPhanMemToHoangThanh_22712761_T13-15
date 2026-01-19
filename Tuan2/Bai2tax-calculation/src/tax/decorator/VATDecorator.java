package tax.decorator;

public class VATDecorator extends TaxDecorator {

    public VATDecorator(TaxComponent component) {
        super(component);
    }

    @Override
    public double getTotalPrice() {
        return component.getTotalPrice() * 1.1;
    }
}

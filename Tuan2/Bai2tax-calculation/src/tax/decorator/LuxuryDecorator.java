package tax.decorator;

public class LuxuryDecorator extends TaxDecorator {

    public LuxuryDecorator(TaxComponent component) {
        super(component);
    }

    @Override
    public double getTotalPrice() {
        return component.getTotalPrice() * 1.3;
    }
}

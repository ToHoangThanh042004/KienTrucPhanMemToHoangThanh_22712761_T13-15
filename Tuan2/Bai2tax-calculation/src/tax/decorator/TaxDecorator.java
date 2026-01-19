package tax.decorator;

public abstract class TaxDecorator implements TaxComponent {
    protected TaxComponent component;

    public TaxDecorator(TaxComponent component) {
        this.component = component;
    }
}

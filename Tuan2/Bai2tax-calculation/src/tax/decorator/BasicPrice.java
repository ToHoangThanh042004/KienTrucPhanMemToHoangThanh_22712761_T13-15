package tax.decorator;

public class BasicPrice implements TaxComponent {
    private double price;

    public BasicPrice(double price) {
        this.price = price;
    }

    @Override
    public double getTotalPrice() {
        return price;
    }
}

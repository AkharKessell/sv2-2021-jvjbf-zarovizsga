package shipping;

public class NationalPackage implements Transportable {

    private int weight;
    private boolean breakable;
    private static final int PRICE = 1000;
    private static final int PRICE_IF_BREAKABLE = 2;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int calculateShippingPrice() {
        if (!this.breakable) {
            return PRICE;
        } else {
            return PRICE * PRICE_IF_BREAKABLE;
        }
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public boolean isBreakable() {
        return this.breakable;
    }
}

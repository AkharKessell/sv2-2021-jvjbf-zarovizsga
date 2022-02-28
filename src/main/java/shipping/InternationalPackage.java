package shipping;

public class InternationalPackage implements Transportable {

    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;
    private static final int PRICE = 1200;
    private static final int PRICE_IF_BREAKABLE = 2;
    private static final int PRICE_PER_KM = 10;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int calculateShippingPrice() {
        int deliveryPrice = PRICE * (breakable ? PRICE_IF_BREAKABLE : 1);
        return deliveryPrice + (distance * PRICE_PER_KM);
    }

    @Override
    public String getDestinationCountry() {
        return this.destinationCountry;
    }

    public int getDistance() {
        return this.distance;
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

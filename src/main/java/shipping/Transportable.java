package shipping;

public interface Transportable {

    public int getWeight();
    public boolean isBreakable();
    public int calculateShippingPrice();

    default String getDestinationCountry() {
        return "Hungary";
    }
}
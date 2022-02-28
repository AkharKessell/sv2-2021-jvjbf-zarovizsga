package shipping;
import java.util.*;

public class ShippingService {

    private List<Transportable> packages = new ArrayList<>();

    public List<Transportable> getPackages() {
        return this.packages;
    }

    public void addPackage(Transportable transportable) {
        this.packages.add(transportable);
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return this.packages.stream()

                .filter(InternationalPackage.class::isInstance)
                .sorted
                        (Comparator.comparing (p ->
                        ((InternationalPackage) p) .getDistance()))
                .toList();
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return this.packages.stream()

                .filter(p ->
                        p.isBreakable() == breakable
                                &&
                        p.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (Transportable delivery : this.packages) {
            result.compute(delivery.getDestinationCountry(), (k, v) -> v == null ? 1 : v + 1);
        }
        return result;
    }
}
package rentcompany.car;

public class Sonata extends AbstractCar {
    
    public Sonata(int tripDistance) {
        super(tripDistance);
    }

    @Override
    public double getDistancePerLiter() {
        return 10.0;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return "Sonata";
    }

    @Override
    public double getChargeQuantity() {
        return super.getChargeQuantity();
    }
}

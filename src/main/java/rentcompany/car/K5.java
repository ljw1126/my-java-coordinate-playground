package rentcompany.car;

public class K5 extends AbstractCar {
    public K5(int tripDistance) {
        super(tripDistance);
    }

    @Override
    public double getDistancePerLiter() {
        return 13.0;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return "K5";
    }

    @Override
    public double getChargeQuantity() {
        return super.getChargeQuantity();
    }
}

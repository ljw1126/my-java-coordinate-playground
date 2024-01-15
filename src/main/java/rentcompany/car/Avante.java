package rentcompany.car;

public class Avante extends AbstractCar {

    public Avante(int tripDistance) {
        super(tripDistance);
    }

    @Override
    public double getDistancePerLiter() {
        return 15.0; // 15km
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return "Avante";
    }

    @Override
    public double getChargeQuantity() {
        return super.getChargeQuantity();
    }
}

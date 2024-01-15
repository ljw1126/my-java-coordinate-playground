package rentcompany.car;

public abstract class AbstractCar implements Car {

    private double tripDistance;
    private double distancePerLiter;

    public AbstractCar(double tripDistance, double distancePerLiter) {
        this.tripDistance = tripDistance;
        this.distancePerLiter = distancePerLiter;
    }

    public double getChargeQuantity() {
        return tripDistance / distancePerLiter;
    }

}

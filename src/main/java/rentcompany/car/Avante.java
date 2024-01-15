package rentcompany.car;

public class Avante extends AbstractCar {
    private static final double DISTANCE_PER_LITER = 15;
    private String name;
    public Avante(double tripDistance) {
        super(tripDistance, DISTANCE_PER_LITER);
        this.name = "Avante";
    }

    @Override
    public String getName() {
        return name;
    }
}

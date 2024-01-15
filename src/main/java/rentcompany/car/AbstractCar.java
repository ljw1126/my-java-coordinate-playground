package rentcompany.car;

public abstract class AbstractCar {

    protected int tripDistance; // protected : 같은 패키지, 상속 받은 경우 접근 허용

    public AbstractCar(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    // 리터당 이동 거리. 즉, 연비
    public abstract double getDistancePerLiter();

    // 여행하려는 거리
    public abstract double getTripDistance();

    // 차종의 이름
    public abstract String getName();

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}

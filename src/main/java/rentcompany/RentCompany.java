package rentcompany;

import rentcompany.car.AbstractCar;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private List<AbstractCar> carList;

    private RentCompany() {
        this.carList = new ArrayList<>();
    }

    static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(AbstractCar car) {
        this.carList.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for(AbstractCar car : carList) {
            sb.append(car.getName()).append(" : ").append(new Double(car.getChargeQuantity()).intValue()).append("리터\n");
        }

        return sb.toString();
    }
}

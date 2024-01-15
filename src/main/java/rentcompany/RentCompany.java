package rentcompany;

import rentcompany.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String COLON_WITH_SPACE = " : ";
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final String LITTER = "리터";
    private static RentCompany rentCompany = null;
    private List<Car> carList;


    private RentCompany() {
        this.carList = new ArrayList<>();
    }

    public static RentCompany create() {
        if(rentCompany == null) {
            rentCompany = new RentCompany();
        }
        return rentCompany;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();

        for (Car car : carList) {
            sb.append(car.getName())
                    .append(COLON_WITH_SPACE)
                    .append((int) car.getChargeQuantity())
                    .append(LITTER)
                    .append(NEWLINE);
        }

        return sb.toString();
    }
}

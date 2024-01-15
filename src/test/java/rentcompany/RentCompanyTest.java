package rentcompany;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import rentcompany.car.Avante;
import rentcompany.car.K5;
import rentcompany.car.Sonata;

import static org.junit.jupiter.api.Assertions.*;

class RentCompanyTest {

    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    public void report() {
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        Assertions.assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                "K5 : 20리터" + NEWLINE +
                "Sonata : 12리터" + NEWLINE +
                "Avante : 20리터" + NEWLINE +
                "K5 : 30리터" + NEWLINE
        );
    }

}
import inheritance.CaffeineBeverage;
import inheritance.Coffee;
import inheritance.Tea;

import java.util.Arrays;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<CaffeineBeverage> list = Arrays.asList(new Coffee(), new Tea());
        for (CaffeineBeverage caffeineBeverage : list) {
            caffeineBeverage.prepareRecipe();
            System.out.println("==============");
        }
    }
}

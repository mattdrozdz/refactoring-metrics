package refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.before;

import refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.domain.Model;

/**
 * @author mdrozdz
 * Extract Special-Case Logic into Decorators
 */
public class Main {
    public static void main(String[] args) {
        Model m = new Model(10.0f, 50.0f, "Ford Taurus");
        CarRental r1 = new CarRental(m, 5);
        assert (r1.calcPrice() == 250.0f);

        CarRental r2 = new CarRental(m, 5);
        r2.setInsurance(12.5f);
        assert (r2.calcPrice() == 312.5f);

        CarRental r3 = new CarRental(m, 5);
        r3.setInsurance(12.5f);
        r3.setRefuelOnReturn(3.75f);
        assert (r3.calcPrice() == 350.0f);
    }
}

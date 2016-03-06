package refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.after;

import refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.domain.Model;

/**
 * @author mdrozdz
 * Extract Special-Case Logic into Decorators
 */
public class Main {
    public static void main(String[] args) {
        Model m = new Model(10.0f, 50.0f, "Ford Taurus");
        Rental r1 = new CarRental(m, 5);
        assert (r1.calcPrice() == 250.0f);

        Rental r2 = new Insurance(new CarRental(m, 5), 12.5f);
        assert (r2.calcPrice() == 312.5f);

        Rental r3 = new RefuelOnReturn(new Insurance(new CarRental(m, 5), 12.5f), 3.75f);
        assert (r3.calcPrice() == 350.0f);
    }
}

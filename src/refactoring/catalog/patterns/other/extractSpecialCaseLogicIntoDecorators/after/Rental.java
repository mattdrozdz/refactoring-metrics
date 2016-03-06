package refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.after;

import refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.domain.Model;

/**
 * @author mdrozdz
 */
public interface Rental {
    float calcPrice();

    int getDaysRented();

    Model getModel();

    float getFuelConsumed();

    void setFuelConsumed(float amount);
}

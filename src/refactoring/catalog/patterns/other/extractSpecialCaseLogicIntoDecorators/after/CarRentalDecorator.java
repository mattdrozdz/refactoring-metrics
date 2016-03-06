package refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.after;

import refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.domain.Model;

/**
 * @author mdrozdz
 */
public abstract class CarRentalDecorator implements Rental {
    protected Rental rental;

    protected CarRentalDecorator(Rental r) {
        rental = r;
    }

    @Override
    public float calcPrice() {
        return rental.calcPrice();
    }

    @Override
    public int getDaysRented() {
        return rental.getDaysRented();
    }

    @Override
    public float getFuelConsumed() {
        return rental.getFuelConsumed();
    }

    @Override
    public void setFuelConsumed(float amount) {
        rental.setFuelConsumed(amount);
    }

    @Override
    public Model getModel() {
        return rental.getModel();
    }
}

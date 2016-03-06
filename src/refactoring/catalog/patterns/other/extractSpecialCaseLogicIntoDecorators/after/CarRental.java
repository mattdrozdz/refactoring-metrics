package refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.after;

import refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.domain.Model;

/**
 * @author mdrozdz
 */
public class CarRental implements Rental {
    protected float fuelConsumed;
    protected int days;
    protected Model model;
    protected float refuelPrice;

    public CarRental(Model m, int rentalDays) {
        model = m;
        days = rentalDays;
    }

    @Override
    public float calcPrice() {
        float price = (model.price * days);
        return price;
    }

    @Override
    public int getDaysRented() {
        return days;
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public float getFuelConsumed() {
        return fuelConsumed;
    }

    public void setFuelConsumed(float amount) {
        fuelConsumed = amount;
    }

    private float refuelPrice() {
        return (getModel().fuelCapacity - getFuelConsumed()) * refuelPrice;
    }

}

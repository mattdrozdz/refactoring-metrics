package refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.after;

/**
 * @author mdrozdz
 */
public class RefuelOnReturn extends CarRentalDecorator {

    private float refuelPrice;
    public RefuelOnReturn(Rental r, float refuelPrice) {
        super(r);
        this.refuelPrice = refuelPrice;
    }
    private float refuelPrice() {
        return(rental.getModel().fuelCapacity - rental.getFuelConsumed()) * refuelPrice;
    }
    public float calcPrice() {
        return rental.calcPrice() + refuelPrice();
    }

}

package refactoring.catalog.patterns.other.extractSpecialCaseLogicIntoDecorators.after;

/**
 * @author mdrozdz
 */
public class Insurance extends CarRentalDecorator {
    protected float rate;
    public Insurance(Rental r, float rate) {
        super(r);
        this.rate = rate;
    }
    private float insuranceAmount() {
        return rate * rental.getDaysRented();
    }
    public float calcPrice() {
        return rental.calcPrice() + insuranceAmount();
    }
}

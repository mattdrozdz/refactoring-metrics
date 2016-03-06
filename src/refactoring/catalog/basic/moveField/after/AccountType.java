package refactoring.catalog.basic.moveField.after;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class AccountType {
    private double _interestRate;

    public double getInterestRate() {
        return _interestRate;
    }

    public void setInterestRate(double _interestRate) {
        this._interestRate = _interestRate;
    }
}

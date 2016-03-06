package refactoring.catalog.basic.moveField.before;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Account {
    private AccountType _type;
    private double _interestRate;
    double interestForAmount_days (double amount, int days) {
        return _interestRate * amount * days / 365;
    }
}

package refactoring.catalog.basic.moveField.after;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Account {
    private AccountType _type;
    double interestForAmount_days (double amount, int days) {
        return _type.getInterestRate() * amount * days / 365;
    }
}

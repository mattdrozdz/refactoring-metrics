package refactoring.catalog.basic.moveMethod.after;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Account {

    double overdraftCharge() {
        return _type.overdraftCharge(_daysOverdrawn);
    }

    double bankCharge() {
        double result = 4.5;
        if (_daysOverdrawn > 0) result +=
                _type.overdraftCharge(_daysOverdrawn);
        return result;
    }

    private AccountType _type;
    private int _daysOverdrawn;
}

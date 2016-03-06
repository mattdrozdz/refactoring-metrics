package refactoring.catalog.basic.moveMethod.after;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class AccountType {
    public boolean isPremium() {
        return true;
    }

    double overdraftCharge(int daysOverdrawn) {
        if (isPremium()) {
            double result = 10;
            if (daysOverdrawn > 7) result += (daysOverdrawn - 7) * 0.85;
            return result;
        }
        else return daysOverdrawn * 1.75;
    }
}

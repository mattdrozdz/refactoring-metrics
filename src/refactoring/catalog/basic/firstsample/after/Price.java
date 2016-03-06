package refactoring.catalog.basic.firstsample.after;

/**
 * @author mdrozdz
 */
public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

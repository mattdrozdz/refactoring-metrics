package refactoring.catalog.basic.replacetempwithquery.after;

/**
 * @author mdrozdz
 * Chapter 6. Composing Methods
 */
public class Main {
    private int _itemPrice;
    private int _quantity;

    double getPrice() {
        return basePrice() * discountFactor();
    }

    private double discountFactor() {
        if (basePrice() > 1000) return 0.95;
        else return 0.98;
    }

    private int basePrice() {
        return _quantity * _itemPrice;
    }
}

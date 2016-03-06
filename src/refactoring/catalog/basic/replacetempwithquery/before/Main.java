package refactoring.catalog.basic.replacetempwithquery.before;

/**
 * @author mdrozdz
 * Chapter 6. Composing Methods
 */
public class Main {
    private int _itemPrice;
    private int _quantity;

    double getPrice() {
        int basePrice = _quantity * _itemPrice;
        double discountFactor;
        if (basePrice > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrice * discountFactor;
    }
}

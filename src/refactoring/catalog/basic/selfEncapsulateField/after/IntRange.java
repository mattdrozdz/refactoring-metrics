package refactoring.catalog.basic.selfEncapsulateField.after;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 */
public class IntRange {
    boolean includes (int arg) {
        return arg >= getLow() && arg <= getHigh();
    }
    void grow(int factor) {
        setHigh (getHigh() * factor);
    }
    private int _low, _high;
    int getLow() {
        return _low;
    }
    int getHigh() {
        return _high;
    }
    void setLow(int arg) {
        _low = arg;
    }
    void setHigh(int arg) {
        _high = arg;
    }
}

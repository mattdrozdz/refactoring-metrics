package refactoring.catalog.basic.selfEncapsulateField.before;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 */
public class IntRange {
    private int _low, _high;
    boolean includes (int arg) {
        return arg >= _low && arg <= _high;
    }
    void grow(int factor) {
        _high = _high * factor;
    }
    IntRange (int low, int high) {
        _low = low;
        _high = high;
    }
}

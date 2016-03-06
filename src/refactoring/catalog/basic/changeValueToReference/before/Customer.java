package refactoring.catalog.basic.changeValueToReference.before;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 */
public class Customer {
    public Customer (String name) {
        _name = name;
    }
    public String getName() {
        return _name;
    }
    private final String _name;
}

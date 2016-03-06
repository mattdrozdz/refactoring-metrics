package refactoring.catalog.basic.replaceDataValueWithObject.before;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 */
public class Order {
    public Order (String customer) {
        _customer = customer;
    }
    public String getCustomer() {
        return _customer;
    }
    public void setCustomer(String arg) {
        _customer = arg;
    }
    private String _customer;
}

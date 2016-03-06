package refactoring.catalog.basic.changeValueToReference.before;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 */
public class Order {
    public Order (String customerName) {
        _customer = new Customer(customerName);
    }
    public void setCustomer(String customerName) {
        _customer = new Customer(customerName);
    }
    public String getCustomerName() {
        return _customer.getName();
    }
    private Customer _customer;
}

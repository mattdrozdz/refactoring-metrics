package refactoring.catalog.basic.replaceDataValueWithObject.after;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 * next step -> change value to reference
 */
public class Order {
    public Order (String customer) {
        _customer = new Customer(customer);
    }
    public String getCustomerName() {
        return _customer.getName();
    }
    private Customer _customer;
    public void setCustomer(String customerName) {
        _customer = new Customer(customerName);
    }
}

package refactoring.catalog.basic.replaceDataValueWithObject.nextStep;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 * changeValueToReference
 */
public class Order {
    public Order (String customerName) {
        _customer = Customer.getNamed(customerName);
    }
    public void setCustomer(String customerName) {
        _customer = Customer.getNamed(customerName);
    }
    public String getCustomerName() {
        return _customer.getName();
    }
    private Customer _customer;
}

package refactoring.catalog.basic.replaceDataValueWithObject.nextStep;

import java.util.Collection;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 * changeValueToReference
 */
public class Client {
    private static int numberOfOrdersFor(Collection<Order> orders, String
            customer) {
        int result = 0;
        for (Order order : orders) {
            if (order.getCustomerName().equals(customer)) result++;
        }
        return result;
    }
}

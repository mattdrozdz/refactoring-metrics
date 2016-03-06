package refactoring.catalog.basic.changeValueToReference.before;

import java.util.Collection;

/**
 * @author mdrozdz
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

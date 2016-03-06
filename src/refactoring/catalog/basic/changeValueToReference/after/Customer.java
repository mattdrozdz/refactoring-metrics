package refactoring.catalog.basic.changeValueToReference.after;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 */
public class Customer {
    public static Customer getNamed (String name) {
        return _instances.get(name);
    }

    private Customer (String name) {
        _name = name;
    }
    public String getName() {
        return _name;
    }
    private final String _name;

    private static Map<String, Customer> _instances = new HashMap<String, Customer>();
    static void loadCustomers() {
        new Customer ("Lemon Car Hire").store();
        new Customer ("Associated Coffee Machines").store();
        new Customer ("Bilston Gasworks").store();
    }
    private void store() {
        _instances.put(this.getName(), this);
    }
}

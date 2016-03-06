package refactoring.catalog.basic.hideDelegate.before;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Department {
    private String _chargeCode;
    private Person _manager;
    public Department (Person manager) {
        _manager = manager;
    }
    public Person getManager() {
        return _manager;
    }
}

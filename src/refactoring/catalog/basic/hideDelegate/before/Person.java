package refactoring.catalog.basic.hideDelegate.before;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Person {
    Department _department;
    public Department getDepartment() {
        return _department;
    }
    public void setDepartment(Department arg) {
        _department = arg;
    }
}

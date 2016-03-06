package refactoring.catalog.basic.hideDelegate.after;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Person {
    Department _department;

    public void setDepartment(Department arg) {
        _department = arg;
    }

    public Person getManager() {
        return _department.getManager();
    }
}

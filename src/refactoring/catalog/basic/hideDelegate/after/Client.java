package refactoring.catalog.basic.hideDelegate.after;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Client {
    public static void main(String[] args) {
        Person worker = new Person();
        Person manager = worker.getManager();
    }
}

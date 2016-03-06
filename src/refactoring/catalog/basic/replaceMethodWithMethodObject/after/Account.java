package refactoring.catalog.basic.replaceMethodWithMethodObject.after;

/**
 * @author mdrozdz
 * Chapter 6. Composing Methods
 */
public class Account {
    int gamma (int inputVal, int quantity, int yearToDate) {
        return new Gamma(this, inputVal, quantity,
                yearToDate).compute();
    }

    public int delta() {
        return 0;
    }
}

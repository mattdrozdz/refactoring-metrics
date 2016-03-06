package refactoring.catalog.basic.replaceMagicNumberWithSymbolicConstant.after;

/**
 * @author mdrozdz
 * Chapter 8. Organizing Data
 */
public class Main {
    double potentialEnergy(double mass, double height) {
        return mass * GRAVITATIONAL_CONSTANT * height;
    }
    static final double GRAVITATIONAL_CONSTANT = 9.81;
}

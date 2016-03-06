package refactoring.catalog.patterns.generalization.replaceHardCodedNotoficationsWithObserver.before;

import junit.framework.Test;

/**
 * @author mdrozdz
 */
public class TextTestResult extends TestResult {
    public synchronized void addError(Test test, Throwable t) {
        super.addError(test, t);
        System.out.println("E");
    }
    public synchronized void addFailure(Test test, Throwable t) {
        super.addFailure(test, t);
        System.out.print("F");
    }
}

package refactoring.catalog.patterns.generalization.replaceHardCodedNotoficationsWithObserver.before;

import junit.framework.Test;

/**
 * @author mdrozdz
 */
public class UITestResult extends TestResult {
    private TestRunner fRunner;

    UITestResult(TestRunner runner) {
        fRunner= runner;
    }

    public synchronized void addFailure(Test test, Throwable t) {
        fRunner.addFailure(this, test, t);  // notification to TestRunner
    }

}

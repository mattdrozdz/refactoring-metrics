package refactoring.catalog.patterns.generalization.replaceHardCodedNotoficationsWithObserver.before;

import junit.framework.Test;

import java.awt.*;

/**
 * @author mdrozdz
 */
public class TestRunner extends Frame {
    // TestRunner for AWT
    private TestResult fTestResult;
    protected TestResult createTestResult() {
        return new UITestResult(this);   // hard-coded to UITestResult
    }
    synchronized public void runSuite() {
        fTestResult = createTestResult();
//        testSuite.run(fTestResult);
    }
    public void addFailure(TestResult result, Test test, Throwable t) {
        // display the failure in a graphical AWT window
    }
}

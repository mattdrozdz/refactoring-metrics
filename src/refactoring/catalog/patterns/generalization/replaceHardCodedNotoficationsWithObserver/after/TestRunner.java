package refactoring.catalog.patterns.generalization.replaceHardCodedNotoficationsWithObserver.after;

import junit.framework.Test;

import java.awt.*;

/**
 * @author mdrozdz
 */
public class TestRunner extends Frame implements TestListener {
    private static final long serialVersionUID = -6514642319145726381L;

    protected TestResult createTestResult() {
        TestResult result = new TestResult();
        result.addObservers(this);
        return result;
    }

    protected synchronized void doRun(Test suite, boolean wait) {
        TestResult result = createTestResult();
    }

    @Override
    public void addFailure(TestResult result, Test test, Throwable t) {
        System.out.println("addFailure");
    }

    @Override
    public void addError(TestResult result, Test test, Throwable t) {
        System.out.println("addError");
    }

    @Override
    public void startTest(TestResult result, Test test) {
        System.out.println("startTest");
    }

    @Override
    public void endTest(TestResult result, Test test) {
        System.out.println("endTest");
    }
}

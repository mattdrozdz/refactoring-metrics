package refactoring.catalog.patterns.generalization.replaceHardCodedNotoficationsWithObserver.after;


import junit.framework.Test;

/**
 * @author mdrozdz
 */
public interface TestListener {
    void addFailure(TestResult result, Test test, Throwable t);

    void addError(TestResult result, Test test, Throwable t);

    void startTest(TestResult result, Test test);

    void endTest(TestResult result, Test test);
}

package refactoring.catalog.patterns.simplification.replaceConditionalCalculationsWithStrategy.after;

/**
 * @author mdrozdz
 */
public class TermLoanCapital extends CapitalStrategy {

    protected double duration() {
        return calcDuration(loan.getStart(), loan.getMaturity());
    }
    protected double riskAmount() {
        return loan.getOutstanding();
    }
}

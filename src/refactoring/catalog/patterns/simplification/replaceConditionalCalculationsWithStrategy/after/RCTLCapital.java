package refactoring.catalog.patterns.simplification.replaceConditionalCalculationsWithStrategy.after;

/**
 * @author mdrozdz
 */
public class RCTLCapital extends CapitalStrategy {

    private double calcUnusedPercentage() {
        if (loan.getRating() > 4) return 0.95;
        else return 0.50;
    }

    private double calcUnusedRiskAmount() {
        return (loan.getNotional() - loan.getOutstanding()) * calcUnusedPercentage();
    }

    protected double duration() {
        double revolverDuration = calcDuration(loan.getStart(), loan.getExpiry());
        double termDuration = calcDuration(loan.getExpiry(), loan.getMaturity());
        return revolverDuration + termDuration;    }

    protected double riskAmount() {
        return loan.getOutstanding() + calcUnusedRiskAmount();
    }

}

package refactoring.catalog.patterns.simplification.replaceConditionalCalculationsWithStrategy.after;

/**
 * @author mdrozdz
 */
public class RevolverCapital extends CapitalStrategy {

    private double calcUnusedPercentage() {
        if (loan.getRating() > 4) return 0.75;
        else return 0.25;
    }

    private double calcUnusedRiskAmount() {
        return (loan.getNotional() - loan.getOutstanding()) * calcUnusedPercentage();
    }

    protected double duration() {
        return calcDuration(loan.getStart(), loan.getExpiry());
    }

    protected double riskAmount() {
        return loan.getOutstanding() + calcUnusedRiskAmount();
    }
}

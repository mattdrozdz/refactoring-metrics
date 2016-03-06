package refactoring.catalog.patterns.simplification.replaceConditionalCalculationsWithStrategy.after;

import java.util.Date;

/**
 * @author mdrozdz
 */
public abstract class CapitalStrategy {

    protected final int MILLIS_PER_DAY = 86400000;
    protected Loan loan;

    private static final int DAYS_PER_YEAR = 365;

    protected abstract double duration();

    public double calc(Loan loan) {
        this.loan = loan;
        return riskAmount() * duration() * RiskFactor.forRiskRating(loan.getRating());
    }

    protected double riskAmount() {
        if (calcUnusedPercentage() != 1.00)
            return loan.getOutstanding() + calcUnusedRiskAmount();
        else
            return loan.getOutstanding();
    }

    private double calcUnusedPercentage() {
        if (loan.getExpiry() != null && loan.getMaturity() != null) {
            if (loan.getRating() > 4)
                return 0.95;
            else
                return 0.50;
        } else if (loan.getMaturity() != null) {
            return 1.00;
        } else if (loan.getExpiry() != null) {
            if (loan.getRating() > 4)
                return 0.75;
            else
                return 0.25;
        }
        return 0.0;
    }

    private double calcUnusedRiskAmount() {
        return (loan.getNotional() - loan.getOutstanding()) * calcUnusedPercentage();
    }

    protected double calcDuration(Date start, Date end) {
        return ((end.getTime() - start.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }
}

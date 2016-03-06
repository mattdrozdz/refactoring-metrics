package refactoring.catalog.patterns.generalization.formTemplateMethod.domain;

import refactoring.catalog.patterns.generalization.formTemplateMethod.before.CapitalStrategy;
import refactoring.catalog.patterns.generalization.formTemplateMethod.before.CapitalStrategyAdvisedLine;
import refactoring.catalog.patterns.generalization.formTemplateMethod.before.CapitalStrategyRevolver;
import refactoring.catalog.patterns.generalization.formTemplateMethod.before.CapitalStrategyTermLoan;

import java.util.Date;
import java.util.List;

/**
 * @author mdrozdz
 */
public class Loan {
    double commitment;
    int riskRating;
    Date maturity;
    double outstanding;
    Date expiry;

    double unusedPercentage;

    private Date start;
    private Date today;
    private List<Payment> payments;
    private CapitalStrategy capitalStrategy;

    private Loan(double commitment, int riskRating, Date maturity, double outstanding, Date expiry, Date start,
                 CapitalStrategy capitalStrategy) {
        this.commitment = commitment;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.outstanding = outstanding;
        this.expiry = expiry;
        this.start = start;
        this.capitalStrategy = capitalStrategy;
    }

    public static Loan newTermLoan(double commitment, Date start, int riskRating, Date maturity) {
        return new Loan(commitment, riskRating, maturity, 0.0, null, start, new CapitalStrategyTermLoan());
    }

    public static Loan newRevolver(double commitment, Date start, Date expiry, int riskRating) {
        return new Loan(commitment, riskRating, null, 0.0, expiry, start, new CapitalStrategyRevolver());
    }

    public static Loan newAdvisedLine(double commitment, Date start, Date expiry, int riskRating) {
        if (riskRating > 3)
            return null;
        Loan advisedLine = new Loan(commitment, riskRating, null, 0.0, expiry, start, new CapitalStrategyAdvisedLine());

        advisedLine.setUnusedPercentage(1.0);
        return advisedLine;
    }

    public double capital() {
        return capitalStrategy.capital(this);
    }

    public double duration() {
        return capitalStrategy.duration(this);
    }

    public double unusedRiskAmount() {
        return commitment - outstanding;
    }

    public double outstandingRiskAmount() {
        return outstanding;
    }

    public double getUnusedPercentage() {
        return unusedPercentage;
    }

    public void setUnusedPercentage(double unusedPercentage) {
        this.unusedPercentage = unusedPercentage;
    }

    public double getCommitment() {
        return commitment;
    }

    public int getRiskRating() {
        return riskRating;
    }

    Date getMaturity() {
        return maturity;
    }

    double getOutstanding() {
        return outstanding;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Date getStart() {
        return start;
    }

    public Date getToday() {
        return today;
    }

    public List<Payment> getPayments() {
        return payments;
    }

}

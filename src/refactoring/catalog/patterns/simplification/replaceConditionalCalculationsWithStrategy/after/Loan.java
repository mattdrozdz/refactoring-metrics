package refactoring.catalog.patterns.simplification.replaceConditionalCalculationsWithStrategy.after;

import java.util.Date;

/**
 * @author mdrozdz
 */
public class Loan {
    private CapitalStrategy capitalStrategy;

    private double notional;
    private double outstanding;
    private int rating;
    private Date start;
    private Date expiry;
    private Date maturity;

    protected Loan(double notional, Date start, Date expiry, Date maturity, int riskRating, CapitalStrategy strategy) {
        this.notional = notional;
        this.start = start;
        this.expiry = expiry;
        this.maturity = maturity;
        this.rating = riskRating;
        this.capitalStrategy = strategy;
    }

    public double calcCapital() {
        return capitalStrategy.calc(this);
    }

    public double getNotional() {
        return notional;
    }

    public double getOutstanding() {
        return outstanding;
    }

    public int getRating() {
        return rating;
    }

    public Date getStart() {
        return start;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Date getMaturity() {
        return maturity;
    }

    public static Loan newRCTL(double notional, Date start, Date expiry,
                               Date maturity, int rating) {
        return new Loan(notional, start, expiry, maturity, rating, new RCTLCapital());
    }
    public static Loan newRevolver(double notional, Date start, Date expiry,
                                   int rating) {
        return new Loan(notional, start, expiry, null, rating, new RevolverCapital());
    }
    public static Loan newTermLoan(double notional, Date start, Date maturity,
                                   int rating) {
        return new Loan(notional, start, null, maturity, rating, new TermLoanCapital());
    }

}

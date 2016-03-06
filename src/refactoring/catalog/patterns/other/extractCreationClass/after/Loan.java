package refactoring.catalog.patterns.other.extractCreationClass.after;

import java.util.Date;

/**
 * @author mdrozdz
 */
public class Loan {
    private double notional;
    private double outstanding;
    private int rating;
    private Date start;
    private CapitalStrategy capitalStrategy;
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

}

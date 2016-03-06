package refactoring.catalog.patterns.utilities.chainConstructors.before;

import refactoring.catalog.patterns.utilities.chainConstructors.domain.CapitalStrategy;
import refactoring.catalog.patterns.utilities.chainConstructors.domain.RevolvingTermROC;
import refactoring.catalog.patterns.utilities.chainConstructors.domain.TermROC;

import java.util.Date;

/**
 * @author mdrozdz
 */
public class Loan {

    private final CapitalStrategy strategy;
    private final float notional;
    private final float outstanding;
    private final int rating;
    private final Date expiry;
    private Date maturity;

    public Loan(float notional, float outstanding, int rating, Date expiry) {
        this.strategy = new TermROC();
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
    }

    public Loan(float notional, float outstanding, int rating, Date expiry, Date maturity) {
        this.strategy = new RevolvingTermROC();
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
        this.maturity = maturity;
    }

    public Loan(CapitalStrategy strategy, float notional, float outstanding, int rating,
                Date expiry, Date maturity) {
        this.strategy = strategy;
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
        this.maturity = maturity;
    }

}

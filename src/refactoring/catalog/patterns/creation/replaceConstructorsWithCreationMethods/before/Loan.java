package refactoring.catalog.patterns.creation.replaceConstructorsWithCreationMethods.before;

import java.util.Date;

/**
 * @author mdrozdz
 * Chapter 6. Creation
 * Replace the constructors with intention-revealing Creation Methods that return object instances.
 */
public class Loan {
    private class CapitalStrategy {}
    private class CapitalStrategyTermLoan extends CapitalStrategy {}
    private class CapitalStrategyRevolver extends CapitalStrategy {}
    private class CapitalStrategyRCTL extends CapitalStrategy {}

    private final double commitment;
    private final double outstanding;
    private final int riskRating;
    private final Date maturity;
    private final Date expiry;
    private CapitalStrategy capitalStrategy;

    public Loan(double commitment, int riskRating, Date maturity) {
        this(commitment, 0.00, riskRating, maturity, null);
    }

    public Loan(double commitment, int riskRating, Date maturity, Date expiry) {
        this(commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(double commitment, double outstanding,
                int customerRating, Date maturity, Date expiry) {
        this(null, commitment, outstanding, customerRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment,
                int riskRating, Date maturity, Date expiry) {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment,
                double outstanding, int riskRating,
                Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        this.capitalStrategy = capitalStrategy;

        if (capitalStrategy == null) {
            if (expiry == null)
                this.capitalStrategy = new CapitalStrategyTermLoan();
            else if (maturity == null)
                this.capitalStrategy = new CapitalStrategyRevolver();
            else
                this.capitalStrategy = new CapitalStrategyRCTL();
        }
    }
}

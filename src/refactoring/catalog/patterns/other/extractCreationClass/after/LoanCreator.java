package refactoring.catalog.patterns.other.extractCreationClass.after;

import java.util.Date;

/**
 * @author mdrozdz
 */
public class LoanCreator {
    public static Loan newAdvisor(double notional, Date start, Date maturity, int rating) {
        return new Loan(notional, start, null, maturity, rating, new TermLoanCapital());
    }

    public static Loan newLetterOfCredit(double notional, Date start, Date maturity, int rating) {
        return new Loan(notional, start, null, maturity, rating, new TermLoanCapital());
    }

    public static Loan newRCTL(double notional, Date start, Date expiry, Date maturity, int rating) {
        return new Loan(notional, start, expiry, maturity, rating, new RCTLCapital());
    }

    public static Loan newRevolver(double notional, Date start, Date expiry, int rating) {
        return new Loan(notional, start, expiry, null, rating, new RevolverCapital());
    }

    public static Loan newSPLC(double notional, Date start, Date maturity, int rating) {
        return new Loan(notional, start, null, maturity, rating, new TermLoanCapital());
    }

    public static Loan newTermLoan(double notional, Date start, Date maturity, int rating) {
        return new Loan(notional, start, null, maturity, rating, new TermLoanCapital());
    }

    public static Loan newVariableLoan(double notional, Date start, Date expiry, Date maturity, int rating) {
        return new Loan(notional, start, expiry, maturity, rating, new RCTLCapital());
    }
}

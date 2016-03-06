package refactoring.catalog.patterns.other.encapsulateSubclassesWithCreationMethods.after;

/**
 * @author mdrozdz
 */
public abstract class Loan {

    protected Loan(/*...*/) {
    }

    public static Loan newTermLoan(/*...*/) {
        return new TermLoan(/*...*/);
    }

    public static Loan newRCTL(/*...*/) {
        return new RCTL(/*...*/);
    }

    public static Loan newRevolver(/*...*/) {
        return new Revolver(/*...*/);
    }
}

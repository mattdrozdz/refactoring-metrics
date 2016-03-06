package refactoring.catalog.patterns.generalization.formTemplateMethod.after;

import refactoring.catalog.patterns.generalization.formTemplateMethod.domain.Loan;

/**
 * @author mdrozdz
 */
public class CapitalStrategyRevolver extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return super.capital(loan) + unusedCapital(loan);
    }

    @Override
    protected double riskAmountFor(Loan loan) {
        return loan.outstandingRiskAmount();
    }

    private double unusedCapital(Loan loan) {
        return loan.unusedRiskAmount() * duration(loan) * unusedRiskFactor(loan);
    }

    private double unusedRiskFactor(Loan loan) {
        return 0;
    }
}

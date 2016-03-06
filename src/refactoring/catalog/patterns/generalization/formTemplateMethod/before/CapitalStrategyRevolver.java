package refactoring.catalog.patterns.generalization.formTemplateMethod.before;

import refactoring.catalog.patterns.generalization.formTemplateMethod.domain.Loan;

/**
 * @author mdrozdz
 */
public class CapitalStrategyRevolver extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return (loan.outstandingRiskAmount() * duration(loan) * riskFactorFor(loan))
                + (loan.unusedRiskAmount() * duration(loan) * unusedRiskFactor(loan));
    }

    private double unusedRiskFactor(Loan loan) {
        return 0;
    }
}

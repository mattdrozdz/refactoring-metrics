package refactoring.catalog.patterns.generalization.formTemplateMethod.before;

import refactoring.catalog.patterns.generalization.formTemplateMethod.domain.Loan;

/**
 * @author mdrozdz
 */
public class CapitalStrategyAdvisedLine extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage() *
                duration(loan) * riskFactorFor(loan);
    }
}

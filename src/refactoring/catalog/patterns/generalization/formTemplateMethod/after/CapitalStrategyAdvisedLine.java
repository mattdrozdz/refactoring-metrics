package refactoring.catalog.patterns.generalization.formTemplateMethod.after;

import refactoring.catalog.patterns.generalization.formTemplateMethod.domain.Loan;

/**
 * @author mdrozdz
 */
public class CapitalStrategyAdvisedLine extends CapitalStrategy {

    @Override
    protected double riskAmountFor(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage();
    }

}

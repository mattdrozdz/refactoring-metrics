package refactoring.catalog.patterns.generalization.formTemplateMethod.before;

import refactoring.catalog.patterns.generalization.formTemplateMethod.domain.Loan;
import refactoring.catalog.patterns.generalization.formTemplateMethod.domain.Payment;

/**
 * @author mdrozdz
 */
public class CapitalStrategyTermLoan extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * duration(loan) * riskFactorFor(loan);
    }

    @Override
    public double duration(Loan loan) {
        return weightedAverageDuration(loan);
    }

    protected double weightedAverageDuration(Loan loan) {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        for (Payment payment : loan.getPayments()) {
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date(), loan) * payment.amount();
        }

        if (loan.getCommitment() != 0.0)
            duration = weightedAverage / sumOfPayments;

        return duration;
    }

}

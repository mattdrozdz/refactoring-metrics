package refactoring.catalog.others.bank.before.domain;

public class ChequeAccount extends BankAccount {

    public ChequeAccount(Long balanceInCents, double creditInterestsRate, double debitInterestRate, long accountFee) {
        super(balanceInCents, creditInterestsRate, debitInterestRate, accountFee);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CHEQUE;
    }
}

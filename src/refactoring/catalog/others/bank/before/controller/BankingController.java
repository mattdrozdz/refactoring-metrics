package refactoring.catalog.others.bank.before.controller;

import refactoring.catalog.others.bank.before.domain.AccountType;
import refactoring.catalog.others.bank.before.domain.BankAccount;
import refactoring.catalog.others.bank.before.domain.BankingAction;
import refactoring.catalog.others.bank.before.domain.Image;
import refactoring.catalog.others.bank.before.exception.BankAccountException;
import refactoring.catalog.others.bank.before.service.Calculator;

public class BankingController {

    private static final long ACCOUNT_REOPEN_FEE_CENTS = 2000;

    private Calculator calculator = new Calculator();

    private ImageServiceDelegate imageServiceDelegate = new ImageServiceDelegate();

    public Image fetchImage(String id) {
        return imageServiceDelegate.fetch(id);
    }

    public Image uploadImage(String id, byte[] data){
        Image image = new Image(id, data);
        imageServiceDelegate.add(image);
        return image;
    }

    public void updateAccount(BankAccount bankAccount, BankingAction bankingAction){
        switch (bankingAction){
            case RECALCULATE_BALANCE :
                calculator.calculate(bankAccount);
                break;
            case CLOSE_ACCOUNT :
                if(bankAccount.isAccountActive()){
                    bankAccount.closeAccount();
                }
                break;
            case REOPEN_ACCOUNT:
                if(!bankAccount.isAccountActive()){
                    if(AccountType.CHEQUE != bankAccount.getAccountType() && bankAccount.getBalanceInCents() - ACCOUNT_REOPEN_FEE_CENTS < 0){
                        throw new BankAccountException("Account does not contain a balance to debit the reopen fee");
                    }else{
                        bankAccount.updateBalance(-ACCOUNT_REOPEN_FEE_CENTS);
                        bankAccount.reopenAccount();
                    }
                }
                break;
            case CHARGE_ACCOUNT_FEE:
                calculator.calculateBalance(bankAccount, -bankAccount.getFeeInCents());
            break;
        }
    }

}
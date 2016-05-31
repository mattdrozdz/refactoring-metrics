package refactoring.catalog.others.bank.before.service;


import refactoring.catalog.others.bank.before.domain.AccountType;
import refactoring.catalog.others.bank.before.domain.BankAccount;
import refactoring.catalog.others.bank.before.exception.BankAccountException;

import java.util.ArrayList;
import java.util.List;

/**
 * https://bitbucket.org/gmarais/dojo-refactoring
 * Exercise 1:
 *
 * This exercise demonstrates the following code smells
 * 1. Bad Naming
 * 2. Comments
 * 4. Duplication
 * 3. Long Method
 */

// this class calculates the updated balance for bank accounts
public class Calculator {

    private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public int countBanksAccounts() {
        return bankAccounts.size();
    }

    public void addBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }

    public void calculate(BankAccount bankAccount){
        //calculate the balance for a savings account
        if(AccountType.SAVINGS == bankAccount.getAccountType()){// side note: it's always better to place the constant on the left, this prevents NullPointerExceptions
            //check has negative balance
            if(bankAccount.getBalanceInCents() < 0){
                throw new BankAccountException("Negative balance not allowed");
            }
            bankAccount.updateBalance((long) (bankAccount.getBalanceInCents() * bankAccount.getCreditInterestsRate()));
        }

        //calculate the balance for a cheque account
        if(AccountType.CHEQUE == bankAccount.getAccountType()){
            if(bankAccount.getBalanceInCents() < 0){
                bankAccount.updateBalance((long) (bankAccount.getBalanceInCents() * bankAccount.getDebitInterestRate()));
            }else{
                bankAccount.updateBalance((long) (bankAccount.getBalanceInCents() * bankAccount.getCreditInterestsRate()));
            }
        }

        //calculate the balance for a cheque money market account
        if(AccountType.MONEY_MARKET == bankAccount.getAccountType()){
            //check has negative balance
            if(bankAccount.getBalanceInCents() < 0){
                throw new BankAccountException("Negative balance not allowed");
            }
            bankAccount.updateBalance((long) (bankAccount.getBalanceInCents() * bankAccount.getCreditInterestsRate()));
        }
    }

    public void calculateBalance(BankAccount bankAccount, long amountInCents){
        //update the balance for a savings account
        if(AccountType.SAVINGS == bankAccount.getAccountType()){
            //cannot go into negative balance
            if(bankAccount.getBalanceInCents() + amountInCents < 0){
                throw new BankAccountException("Insufficient funds");
            }
            bankAccount.updateBalance(amountInCents);
        }

        //update the balance for a cheque account
        if(AccountType.CHEQUE == bankAccount.getAccountType()){
            bankAccount.updateBalance(amountInCents);
        }

        //calculate the balance for a money market account
        if( AccountType.MONEY_MARKET == bankAccount.getAccountType()){
            //cannot go into negative balance
            if(bankAccount.getBalanceInCents() + amountInCents < 0){
                throw new BankAccountException("Insufficient funds");
            }
            bankAccount.updateBalance(amountInCents);
        }
    }
}
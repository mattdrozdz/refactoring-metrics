package refactoring.catalog.others.bank.after.service;

import refactoring.catalog.others.bank.after.domain.BankAccount;

import java.util.ArrayList;
import java.util.List;


public class BankingService {

    private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public int countBanksAccounts() {
        return bankAccounts.size();
    }

    public void addBankAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }

}
package bank.savings;

import bank.BankAccount;

public class SavingAccount extends BankAccount {
    public SavingAccount(String accountHolderName, int accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account type:Saving Account");
    }

    public void addInterest() {
        double interest = balance * 5 / 100;
        balance += interest;
        System.out.println("Interest added: Rs" + interest);
    }
}
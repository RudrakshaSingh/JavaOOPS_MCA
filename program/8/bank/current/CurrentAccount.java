package bank.current;

import bank.BankAccount;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit = 1000.00;

    public CurrentAccount(String accountHolderName, int accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance); // invoke the constructor of the superclass (BankAccount).
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Current Account");
    }

    @Override
    public void withdrawMoney(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println("Rs " + amount + " Withdrawn.");
        } else {
            System.out.println("Overdraft limit exceeded or invalid amount.");
        }
    }
}
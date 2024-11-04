package bank;

public abstract class BankAccount {
    protected String accountHolderName;
    protected int accountNumber;
    protected double balance;

    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void displayAccountType();

    public void depositMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs" + amount + " Deposited");
        } else
            System.out.println("Invalid deposit amount");
    }

    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rs" + amount + " Withdrawn");
        } else
            System.out.println("Insufficient balance or invalid amount");
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolderName + ", Account Number: " + accountNumber);
    }

    public void getBalance() {
        System.out.println("Current Balance: Rs" + balance);
    }
}
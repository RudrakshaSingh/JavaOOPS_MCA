abstract class BankAccount {
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

class SavingAccount extends BankAccount {
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

class CurrentAccount extends BankAccount {
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

public class BankSystem {
    public static void main(String[] args) {

        SavingAccount savingAccount = new SavingAccount("rudra", 3263634, 3000.0);
        System.out.println("\n------------ Saving Account ------------");
        savingAccount.displayAccountInfo();
        savingAccount.displayAccountType();
        savingAccount.getBalance();
        savingAccount.depositMoney(1000.0);
        savingAccount.addInterest();
        savingAccount.getBalance();
        savingAccount.withdrawMoney(2000.56);
        savingAccount.getBalance();
        savingAccount.withdrawMoney(3000);

        CurrentAccount currentAccount = new CurrentAccount("pretti", 32573543, 2800);
        System.out.println("\n------------ Current Account ------------");
        currentAccount.displayAccountInfo();
        currentAccount.displayAccountType();
        currentAccount.depositMoney(200);
        currentAccount.getBalance();
        currentAccount.withdrawMoney(3100);
        currentAccount.getBalance();
        currentAccount.withdrawMoney(900);
        currentAccount.getBalance();
        currentAccount.withdrawMoney(1);

    }
}

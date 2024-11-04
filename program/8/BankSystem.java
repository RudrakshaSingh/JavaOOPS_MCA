import bank.savings.SavingAccount;
import bank.current.CurrentAccount;

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

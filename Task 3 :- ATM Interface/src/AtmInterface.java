import java.util.Scanner;
class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public double checkBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }
}

class ATM {

    private BankAccount account;

    public ATM(BankAccount bankaccount) {
        account = bankaccount;
    }

    public void ShowMenu() {

        System.out.println("ATM Menu");
        System.out.println("========");
        System.out.println("1, Check balance");
        System.out.println("2, Deposit");
        System.out.println("3, withdraw");
        System.out.println("4, Exit");

    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            
            ShowMenu();
            System.out.println("select the option from the Menu.");
            int input = sc.nextInt();

            switch (input) {

                case 1:
                    System.out.println("Your balance is : " + account.checkBalance());
                    break;

                case 2:
                    System.out.print("Deposit Amount: ");
                    double deposit_amount = sc.nextDouble();
                    account.deposit(deposit_amount);
                    System.out.println("Amount is succesfully deposit in your account \nYour current balance is " + account.checkBalance());
                    break;

                case 3:
                    System.out.print("Withdraw Amount : ");
                    double withdraw_amount = sc.nextDouble();
                    if(account.withdraw(withdraw_amount)){
                        System.out.println("Amount is withdraw successfully, you current balance is " + account.checkBalance());
                    }
                    else{
                    System.out.println("Insufficient balance ");
                    }
                    break;

                case 4:
                    System.out.println("Thank you..");
                    sc.close();
                    return;

                default:
                    System.out.println("invalid input...\nPlease enter the valid input.");
            }
        }
    }
}

public class Task3 {

    public static void main(String args[]) {

        BankAccount user_Account = new BankAccount(1000);
        ATM atm = new ATM(user_Account);
       
        atm.run();
    }
}

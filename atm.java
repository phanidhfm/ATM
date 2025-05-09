import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private double balance;
    private Map<Double, String> miniStatement = new LinkedHashMap<>();


    public ATM() {
        this.balance = 0.0; 
    }

    // View Balance
    public void viewBalance() {
        System.out.println("Available Balance: " + balance);
    }

    // Withdraw Amount
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("Invalid amount! Enter a positive value.");
            return;
        }
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= balance) {
                miniStatement.put(withdrawAmount, "Amount Withdrawn");
                System.out.println("Collect the cash: " + withdrawAmount);
                balance -= withdrawAmount;
                viewBalance();
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Please enter the amount in multiples of 500.");
        }
    }

    // Deposit Amount
    public void depositAmount(double depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Invalid deposit amount! Enter a positive value.");
            return;
        }
        miniStatement.put(depositAmount, "Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully!");
        balance += depositAmount;
        viewBalance();
    }

    // View Mini Statement
    public void viewMiniStatement() {
        System.out.println("\nMini Statement:");
        for (Map.Entry<Double, String> entry : miniStatement.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    // Main Method (ATM Simulation)
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);

        int atmNumber = 12345;
        int atmPin = 123;

        System.out.println("Welcome to the ATM Machine!");
        System.out.print("Enter ATM Number: ");
        int enteredAtmNumber = sc.nextInt();
        System.out.print("Enter PIN: ");
        int enteredAtmPin = sc.nextInt();

        if (atmNumber == enteredAtmNumber && atmPin == enteredAtmPin) {
            while (true) {
                System.out.println("\n1. View Available Balance");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4. View Mini Statement");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.viewBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        atm.withdrawAmount(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        atm.depositAmount(depositAmount);
                        break;
                    case 4:
                        atm.viewMiniStatement();
                        break;
                    case 5:
                        System.out.println("Collect your ATM Card.\nThank you for using the ATM!");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Please enter a correct choice.");
                }
            }
        } else {
            System.out.println("Incorrect ATM Number or PIN.");
            sc.close();
            System.exit(0);
        }
    }
}

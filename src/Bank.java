import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bank {

    public int numMoneyInChecking = 0;
    public int numMoneyInSavings = 0;
    ArrayList<User> user1 = Login.loadUsers();
    public ArrayList<User> loadUsers = Login.loadUsers();
    public User currentUser = null;
    //public User currentUser = new User(null, null, null, null, null, null, null, null, null, null, null);

    public void primaryAccount() { //viewing primary acc
        try (Scanner scan = new Scanner(System.in)) {
            Bank bank = new Bank();
            System.out.print("The amount of money in your account is: " + currentUser.getAccMoney());

            System.out.print("Would you like to view your account information? ");
            String choice = scan.nextLine();

            if(choice.equalsIgnoreCase("yes")) {
                bank.viewAccInformation();
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.println("Returning to home screen... ");
            } else {
                System.out.println("Error, please try again. ");
                return;
            }
        }
    }

    //have to check if the user has checking or savings account
    public void accWithdraw(int amtWithdraw) {
        //User currentUser = new User(null, null, null, null, null, null, null, null, null, null, null);
        Scanner scan = new Scanner(System.in);
        if(currentUser.getAccMoney() < 0) {
            System.out.println("Insufficient funds");
        } else {
            System.out.println("Where would you like to withdraw funds from?");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("Checking")) {
                numMoneyInChecking -= amtWithdraw;
                System.out.println("Checking account balance: " + numMoneyInChecking);
            } else {
                numMoneyInSavings -= amtWithdraw;
                System.out.println("Savings account balance: " + numMoneyInSavings);
            }

            System.out.println();
            System.out.println("Account balance: " + currentUser.getAccMoney());
        }
        scan.close();
    }

    public void accDeposit(int amtDeposit) {
        //User currentUser = new User(null, null, null, null, null, null, null, null, null, null, null)
        Scanner scan = new Scanner(System.in);
        if(amtDeposit > 0) {
            System.out.println("Do you want to deposit to Checking or Savings?");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("Checking")) {
                numMoneyInChecking += amtDeposit;
                System.out.println("Checking account balance: " + numMoneyInChecking);
            } else {
                numMoneyInSavings += amtDeposit;
                System.out.println("Savings account balance: " + numMoneyInSavings);
            }
        }

        System.out.println();
        System.out.println("Account balance: " + currentUser.getAccMoney());
        scan.close();
    }

    public void viewAccBalances() {
        //User currentUser = new User(null, null, null, null, null, null, null, null, null, null, null)
        System.out.println("Account balance: " + currentUser.getAccMoney());
    }

    public void viewChecking() {
        System.out.println("Checking account balance: " + numMoneyInChecking);
    }

    public void viewSavings() {
        System.out.println("Savings account balance: " + numMoneyInSavings);
    }

    public void viewAccInformation() {
        //when viewing account information, it shows the money in the account and then asks the question of viewing the acc info

        // remove that^^ and instead just show account information
        // it outputs null for the elements
        // NoSuchElementException at the end of execution for this method

        try(Scanner scan = new Scanner(System.in)) {
            System.out.println();
            System.out.println("------------------------");
            System.out.println(currentUser.getFirstName() + " " + currentUser.getLastName());
            System.out.println("Username: " + currentUser.getUsername());
            System.out.println("Password: " + currentUser.getPassword());
            System.out.println("Email: " + currentUser.getEmail());
            System.out.println("Phone number: " + currentUser.getPhoneNum());
            System.out.println("Account type: " + currentUser.getAccType());
            System.out.println("Date created: " + currentUser.getDateCreated());
            System.out.println("------------------------");

            //-----the print statements are returning null-----

            System.out.println();
            System.out.println("Would you like to return to the main menu?");
            String choice = scan.nextLine();

            if(choice.equalsIgnoreCase("Yes")) {
                return;
            } else {
                System.out.println("Staying on this menu ...");
            }
        } catch(NoSuchElementException e) {
            System.out.println("Element does not exist. Try again.");
        }
    }
}

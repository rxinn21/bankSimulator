import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bank {

    public Scanner scan = new Scanner(System.in);
    public double numMoneyInAcc;
    ArrayList<User> loadUsers = Login.loadUsers();
    public User currentUser = null;

    public Bank(User currentUser, ArrayList<User> loadUsers) {
        this.currentUser = currentUser;
        this.loadUsers = loadUsers;
        numMoneyInAcc = currentUser.getAccMoney();
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<User> getLoadUsers() {
        return loadUsers;
    }

    public void setLoadUsers(ArrayList<User> loadUsers) {
        this.loadUsers = loadUsers;
    }

    public void currentUser() {
        System.out.println("Logged in as " + currentUser.getFirstName() + " " + currentUser.getLastName());
    }

    public void primaryAccount() { //viewing primary acc
        try {
            System.out.println("The amount of money in your account is: $" + numMoneyInAcc);

            System.out.println();
            System.out.print("Would you like to view your account information? (Y/N): ");
            String choice = scan.nextLine();

            if(choice.equalsIgnoreCase("y")) {
                viewAccInformation();
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("Returning to home screen... ");
            } else {
                System.out.println("Error, please try again. ");
            }
        } catch (NoSuchElementException | NullPointerException e) {
            System.out.println("Error, please try again. Error in Bank.java");
        }
    }

    //have to check if the user has checking or savings account
    public void accWithdraw(int amtWithdraw) {
        if(currentUser.getAccMoney() < 0) {
            System.out.println("Insufficient funds");
        } else {
            numMoneyInAcc -= amtWithdraw;
            System.out.println("You withdrew $" + amtWithdraw);
        }

        System.out.println();
        System.out.println("Account balance: " + numMoneyInAcc);
    }

    //need to make it so that the account balance updates and doesn't stay stagnant. ex: if you deposit 1k and ur balance is 9k, then when you withdraw it should be 8k again not 7k

    public void accDeposit(int amtDeposit) {
        if(amtDeposit > 0) {
            numMoneyInAcc += amtDeposit;
            System.out.println("Deposited $" + amtDeposit);
        } else {
            System.out.println("Insufficient funds");
        }

        System.out.println();
        System.out.println("Account balance: $" + numMoneyInAcc);
    }

    public void viewAccBalances() {
        //User currentUser = new User(null, null, null, null, null, null, null, null, null, null, null)
        System.out.println("Account balance: " + numMoneyInAcc);
    }

    public void viewAccInformation() {

        try {
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

        } catch(NoSuchElementException e) {
            System.out.println("Element does not exist. Try again.");
        }
    }
}

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) { // error: incompatible types: void cannot be converted to boolean // main return type causing error
        System.out.println("Welcome to Rain Bank! Enter your information below to continue");
        System.out.println("--------------------------------------------------------------");

        ArrayList<User> userList = Login.loadUsers();
        User loggedUser = null;
        Bank bank = null;
        Login login = new Login();

        try {
            loggedUser = Login.authenticateLoginUser(userList);
            if (loggedUser != null) { //login method for authenticating the logging in by the user
                bank = new Bank(loggedUser, userList);
                System.out.println();

                int choice = 0;
                boolean running = true;

                while (running) { //while statement to let the user make a choice

                    System.out.println();
                    System.out.println("Logged in as " + loggedUser.getFirstName() + " " + loggedUser.getLastName());
                    System.out.println();

                    System.out.println("Please select one of these options: ");
                    System.out.println("------------------xx-----------------");
                    System.out.println("1. Deposit money");
                    System.out.println("2. Withdraw money");
                    System.out.println("3. View account balance");
                    System.out.println("4. View account information");
                    System.out.println("5. Log out");
                    System.out.println("------------------xx-----------------");

                    //--------menu configurations--------

                    System.out.println();
                    System.out.print("Enter the number that you would like to select: ");
                    choice = scan.nextInt();
                    String back;
                    switch (choice) { //fix program immediately exiting without waiting for user input (07.08)
                        case 1:
                            System.out.print("Enter the amount to deposit: $");
                            int depositAmt = scan.nextInt();
                            bank.accDeposit(depositAmt);

                            System.out.println();
                            scan.nextLine();
                            System.out.print("Would you like to go back to the main menu? (Y/N): ");
                            back = scan.nextLine();
                            if(back.equalsIgnoreCase("Y")) {
                                break;
                            } else {
                                System.out.println("Thank you for logging in. See you soon!");
                                System.exit(0);
                            }

                        case 2:
                            System.out.print("Enter the amount to withdraw: $");
                            int withdrawAmt = scan.nextInt();
                            bank.accWithdraw(withdrawAmt);

                            System.out.println();
                            scan.nextLine();
                            System.out.print("Would you like to go back to the main menu? (Y/N): ");
                            back = scan.nextLine();
                            if(back.equalsIgnoreCase("Y")) {
                                break;
                            } else {
                                System.out.println("Thank you for logging in. See you soon!");
                                System.exit(0);
                            }

                        case 3:
                            bank.viewAccBalances();

                            System.out.println();
                            scan.nextLine();
                            System.out.print("Would you like to go back to the main menu? (Y/N): ");
                            back = scan.nextLine();
                            if(back.equalsIgnoreCase("Y")) {
                                break;
                            } else {
                                System.out.println("Thank you for logging in. See you soon!");
                                System.exit(0);
                            }

                        case 4:
                            bank.primaryAccount();

                            System.out.println();
                            scan.nextLine();
                            System.out.print("Would you like to go back to the main menu? (Y/N): ");
                            back = scan.nextLine();
                            if(back.equalsIgnoreCase("Y")) {
                                break;
                            } else {
                                System.out.println("Thank you for logging in. See you soon!");
                                System.exit(0);
                            }

                        case 5:
                            System.out.println("Logging out..");
                            running = false;
                            break;
                    }
                }
                scan.close();
            } else {
                System.out.println("Login unsuccessful. Please try again");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error. Please try again. Error in Main.");
        }
    }

}

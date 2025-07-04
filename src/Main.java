import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) { // error: incompatible types: void cannot be converted to boolean // main return type causing error
        Login login = new Login();
        System.out.println("Welcome to Rain Bank! Enter your information below to continue");
        System.out.println("--------------------------------------------------------------");

        System.out.print("Username: ");
        String username = scan.nextLine();
        System.out.print("Password: ");
        String password = scan.nextLine();

        if(login.performLogin(username, password)) { //login method for authenticating the logging in by the user
            Bank bank = new Bank();

            System.out.println();

            System.out.println("Please select one of these options: ");
            System.out.println("------------------xx-----------------");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. View account balances");
            System.out.println("4. View account information");
            System.out.println("5. Log out");
            System.out.println("------------------xx-----------------");

            //--------menu configurations--------

            System.out.println();
            System.out.print("Enter the number that you would like to select: ");
            int choice = 0;

            while(choice != 5) { //while statement to let the user make a choice
                choice = scan.nextInt();
                switch(choice) {
                    case 1:
                        System.out.println("Enter the amount to deposit: ");
                        int depositAmt = scan.nextInt();
                        bank.accDeposit(depositAmt);
                        break;
                    case 2:
                        System.out.println("Enter the amount to withdraw");
                        int withdrawAmt = scan.nextInt();
                        bank.accWithdraw(withdrawAmt);
                        break;
                    case 3:
                        bank.viewAccBalances();
                        break;
                    case 4:
                        bank.primaryAccount();
                        break;
                    case 5:
                        System.out.println("Logging out..");
                        break;
                }
            }
        } else {
            System.out.println("Login unsuccessful. Please try again");
        }
    }

}

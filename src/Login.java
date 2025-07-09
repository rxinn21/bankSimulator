import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
//import java.util.Scanner;

public class Login {
    //getting incompatible types: void cannot be converted to boolean error (06.17.25)

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/raindineva/Desktop/coding projects/bankSimulator/bankSimulator/src/Bank User Credentials.csv"))) { //reads the csv file
            String line; //initializes the first line
            while ((line = br.readLine()) != null) { //while there is writing in the file
                String[] arr = line.split(","); //the file will be split by the commas
                if (arr.length < 11) {
                    System.out.println("Invalid credentials");
                    continue;
                }
                User user = new User(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[10]);
                users.add(user);
            }
        } catch (IOException e) { //if there is no file it doesnt load
            System.out.println("There is an error loading this file");
        }
        return users;
    }

    public static User authenticateLoginUser(ArrayList<User> users) { //authenticates if user is a client
        try (BufferedReader brU = new BufferedReader(new FileReader("/Users/raindineva/Desktop/coding projects/bankSimulator/bankSimulator/src/Bank User Credentials.csv"))) {
            System.out.print("Enter your username: ");
            String username = Main.scan.nextLine();
            System.out.print("Enter your password: ");
            String password = Main.scan.nextLine();
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        } catch (Exception e) {
            System.out.println("There is an error authenticating user");
        }
        return null;
    }

}

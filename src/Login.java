import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
//import java.util.Scanner;

public class Login {
    String username;
    String password;
    //getting incompatible types: void cannot be converted to boolean error (06.17.25)

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasssword() {
        return password;
    }

    public boolean authenticateLoginUser(String username, String password) { //authenticates if user is a client
        try (BufferedReader br = new BufferedReader(new FileReader("Bank User Credentials.csv"))) { //reads the csv file
            String line; //initializes the first line
            while((line = br.readLine()) != null) { //while there is writing in the file
                String[] arr = line.split(","); //the file will be split by the commas
                ArrayList<String> data = new ArrayList<>(Arrays.asList(arr)); //and the data will be put into an arraylist

                String fileUsername = data.get(3); //the username should be the 3rd data val
                String filePassword = data.get(4); //the password should be the 4th data val

                if(fileUsername.equals(username) && filePassword.equals(password)) { //if they match, then it's true
                    return true;
                }
            }
        } catch (IOException e) { //if there is no file it doesnt load
            System.out.println("There is an error loading this file");
        }
        return false; //if no match is found, return false
    }

    public boolean performLogin(String username, String password) { //performs the login
        if (authenticateLoginUser(username, password)) { //if the method is true
            System.out.println("Login successful!"); //the login is successful
            return true; //and the data returns true
        } else { //if not
            System.out.println("Invalid credentials. Please try again."); //then the credentials are not true
            return false; //return false
        }
    }

    public static ArrayList<User> loadUsers() { //load users from CSV file
        ArrayList<User> users = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("Bank User Credentials.csv"))) {
            String line;

            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length < 11) {
                    System.out.println("Invalid data format");
                    continue;
                }
                User user = new User(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9], parts[10]);
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("An error has occurred. Try again.");
        } return users;
    }
}

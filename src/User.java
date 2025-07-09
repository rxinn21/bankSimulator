//when introducing a class like this, match every single element to the one in the CSV file in the EXACT same order, or the CSV file will not be read correctly


public class User {
    public String accNum;
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public String email;
    public String phoneNum;
    public String accIdentifier;
    public String accType;
    public String accMoney;
    public String dateCreated;

    public User(String accNum, String firstName, String lastName, String username, String password, String email, String phoneNum, String accIdentifier, String accType, String accMoney, String dateCreated) {
        this.accNum = accNum;// have to use parseint
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.accIdentifier = accIdentifier;
        this.accType = accType;
        this.accMoney = accMoney; //have to use parseint
        this.dateCreated = dateCreated;
    }

    public void setAccMoney(String accMoney) {
        this.accMoney = accMoney;
    }

    public double getAccMoney() {
        return Double.parseDouble(accMoney);
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setAccIdentifier(String accIdentifier) {
        this.accIdentifier = accIdentifier;
    }

    public String getAccIdentifier() {
        return accIdentifier;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccType() {
        return accType;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateCreated() {
        return dateCreated;
    }
}

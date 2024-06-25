package Model;

public class user {
    private static final long serialVersionUID = 1L;
    private int Id;
    private String userName;
    private String password;
    private String phoneNumber;
    private  String role;

    public user() {
    }

    public user(int id, String userName, String password, String phoneNumber, String role) {
        Id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

package Beans;

public class User {

    private int id;
    private String fullName;
    private String email;
    private String telephone;
    private String login;
    private String password;
    private int role=0;
    private String verificationCode;
    public static User user=null;

    public User(){};
    public User(int id, String fullName, String email, String telephone, String login, String password, int role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
        this.role = role;

    }
    public User(int id, String fullName, String email, String telephone, String login, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.login = login;
        this.password = password;

    }
    public User(int id, String fullName, String email, String telephone, String login, String password, int role,String verificationCode) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
        this.role = role;
        this.verificationCode=verificationCode;
    }
    public User(int id, String fullName, String email, String telephone, String login, String password,String verificationCode) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
        this.verificationCode=verificationCode;
    }

    public User( String fullName, String email, String telephone, String login, String password, int role) {
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User( String fullName, String email, String telephone, String login, String password) {
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}

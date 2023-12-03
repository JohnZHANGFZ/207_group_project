package use_case.login;

public class LoginInputData {
    final private String username;
    final private String password;

    public LoginInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public boolean isUsernameEmpty() {
        return username.isEmpty();
    }
    public boolean isPasswordEmpty() {
        return password.isEmpty();
    }
    public boolean isUsernameTooShort() {
        return username.length() < 3;
    }
    public boolean isPasswordTooShort() {
        return password.length() < 3;
    }
    public boolean isUsernameTooLong() {
        return username.length() > 20;
    }
    public boolean isPasswordTooLong() {
        return password.length() > 20;
    }
    public boolean isUsernameInvalid() {
        return !username.matches("[a-zA-Z0-9]+");
    }
    public boolean isPasswordInvalid() {
        return !password.matches("[a-zA-Z0-9]+");
    }
    public boolean isUsernameValid() {
        return !isUsernameEmpty() && !isUsernameTooShort() && !isUsernameTooLong() && !isUsernameInvalid();
    }
    public boolean isPasswordValid() {
        return !isPasswordEmpty() && !isPasswordTooShort() && !isPasswordTooLong() && !isPasswordInvalid();
    }

}

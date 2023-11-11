package use_case.signup;

public class SignupInputData {

    final private String username;

    final private String password;

    public SignupInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() { return username; }

    String getPassword() { return  password; }

}

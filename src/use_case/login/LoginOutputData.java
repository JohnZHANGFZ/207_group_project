package use_case.login;

public class LoginOutputData {
    private final String user;
    private boolean failure;

    public LoginOutputData(String user, boolean failure) {
        this.user = user;
        this.failure = failure;
    }

    public String getUsername() { return user; }
}

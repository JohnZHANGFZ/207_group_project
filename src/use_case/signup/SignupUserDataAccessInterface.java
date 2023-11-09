package use_case.signup;

public interface SignupUserDataAccessInterface {

    boolean existByName(String identifier);

    void save(User user);
}

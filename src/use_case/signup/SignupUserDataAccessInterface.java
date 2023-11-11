package use_case.signup;
import entity.User;

public interface SignupUserDataAccessInterface {

    boolean existByName(String identifier);

    void save(User user);
}

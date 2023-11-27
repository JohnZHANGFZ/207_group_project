package use_case.signup;
import entity.User;

import java.io.FileNotFoundException;

public interface SignupUserDataAccessInterface {

    boolean existByName(String identifier);

    void save(User user) throws FileNotFoundException;
}

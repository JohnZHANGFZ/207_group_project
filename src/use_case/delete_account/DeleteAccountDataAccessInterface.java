package use_case.delete_account;

public interface DeleteAccountDataAccessInterface {
    boolean existsByName(String identifier);
    boolean deleteUser(String username);
}

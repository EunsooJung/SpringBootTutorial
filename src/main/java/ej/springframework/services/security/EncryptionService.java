package ej.springframework.services.security;

/**
 * Created by eunsoojung on 9/7/16.
 */
public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}

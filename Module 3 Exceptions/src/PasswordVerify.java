package models;

import exceptions.PasswordVerifyException;

public class PasswordVerify {
    private String username;
    private String password;

    public PasswordVerify(String username, String password) throws PasswordVerifyException {
        if (!isValidUsername(username)) {
            throw new PasswordVerifyException("Invalid username: Must be at least 6 characters and contain at least one digit.");
        }
        if (!isValidPassword(password)) {
            throw new PasswordVerifyException("Invalid password: Must be at least 8 characters and contain at least one special character (!@#$%).");
        }
        this.username = username;
        this.password = password;
    }

    private boolean isValidUsername(String username) {
        return username.length() >= 6 && username.matches(".*\\d.*");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*[!@#$%].*");
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Password: [hidden]";
    }
}

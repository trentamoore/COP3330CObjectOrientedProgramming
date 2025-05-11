package app;

import models.PasswordVerify;
import exceptions.PasswordVerifyException;
import java.util.Scanner;

public class AccountSetupApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordVerify[] accounts = new PasswordVerify[4];
        int count = 0;

        System.out.println("Username must be at least 6 characters long and contain at least one digit.");
        System.out.println("Password must be at least 8 characters long and contain at least one special character (!@#$%).");

        while (count < 4) {
            System.out.print("Enter username: ");
            String username = scanner.next();

            System.out.print("Enter password: ");
            String password = scanner.next();

            try {
                accounts[count] = new PasswordVerify(username, password);
                System.out.println("Account successfully created.");
                count++;
            } catch (PasswordVerifyException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\nAccounts created successfully:");
        for (PasswordVerify account : accounts) {
            System.out.println(account);
        }
    }
}

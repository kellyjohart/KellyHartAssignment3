package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            UserService userService = new UserService();
            userService.generateUsers("src/main/resources/data.txt");
            String username;
            String password;
            int loginAttempts = 0;
            final int MAX_ATTEMPTS = 5;

            while (loginAttempts < MAX_ATTEMPTS) {
                System.out.println("Please enter your email: ");
                username = scanner.nextLine();
                System.out.println("Please enter your password: ");
                password = scanner.nextLine();

                User validUser = userService.validateUser(username, password);
                if (validUser != null) {
                    System.out.println("Welcome " + validUser.getName());
                    break;
                } else {
                    loginAttempts++;
                    if (loginAttempts == MAX_ATTEMPTS) {
                        System.out.println("Too many failed login attempts. Try again later.");
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Scanner Failed" + e.getMessage());
        }

    }

}

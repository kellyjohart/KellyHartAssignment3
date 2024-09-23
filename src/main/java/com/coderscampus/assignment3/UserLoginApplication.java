package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) {

        UserService userService = new UserService();
        userService.generateUsers("src/main/resources/data.txt");
        Scanner scanner = new Scanner(System.in);
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

    }

}

/*import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService;
        try {
            userService = new UserService("src/main/java/data.txt");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        int attempts = 0;
        while (attempts < 5) {
            System.out.print("Enter username: ");
            String email = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            User user = userService.validateUser(email, password);
            if (user != null) {
                System.out.println("Welcome " + user.getName());
                return;
            } else {
                System.out.println("Invalid username or password. Please try again.");
                attempts++;
            }
        }
        System.out.println("Too many failed login attempts. Try again later.");
    }
}

 */
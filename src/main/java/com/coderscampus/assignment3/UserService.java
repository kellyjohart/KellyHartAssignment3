package com.coderscampus.assignment3;

public class UserService {
    private User[] userArray;

    public void generateUsers(String filename) {
        FileService fileService = new FileService();
        userArray = fileService.readFile(filename);
    }

    public User validateUser(String username, String password) {
        for (User user : userArray) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}

/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users;

    public UserService(String filePath) throws IOException {
        users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                users.add(new User(parts[0], parts[1], parts[2]));
            }
        }
    }

    public User validateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
*/
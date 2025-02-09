package com.coderscampus.assignment3;

public class UserService {
    private User[] userArray;
    private final FileService fileService = new FileService();
    public void generateUsers(String filename) {
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


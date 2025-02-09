package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileService {
    public User[] readFile(String filename) {
        String line;
        User[] userArray = new User[4];
        int lineCount = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                User user = new User(userData[0], userData[1], userData[2]);
                userArray[lineCount] = user;
                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return userArray;
    }
}
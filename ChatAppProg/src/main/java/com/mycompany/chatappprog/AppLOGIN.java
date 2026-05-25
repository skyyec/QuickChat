/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatappprog;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class AppLOGIN {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String phone;

    private Scanner input = new Scanner(System.in);

    // Registration process
    public void register() {
        System.out.println("\n---- Registration ----");

        System.out.print("Enter your Name: ");
        this.name = input.nextLine();

        System.out.print("Enter your Surname: ");
        this.surname = input.nextLine();

        // Username input
        System.out.print("Enter your Username: ");
        this.username = input.nextLine();
        if (checkUsername(this.username)) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted");
        }

        // Password input
        System.out.print("Enter your Password: ");
        this.password = input.nextLine();
        if (checkPasswordComplexity(this.password)) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted");
        }

        // Phone number input
        System.out.print("Enter Phone Number (without +27): ");
        String left = input.nextLine();
        this.phone = "+27" + left;
        if (checkCellPhoneNumber(this.phone)) {
            System.out.println("Cell phone number successfully added");
        } else {
            System.out.println("Cell phone number is not correctly formatted");
        }
    }

    // Login process
    public void login() {
        System.out.println("\n---- Login now ----");

        System.out.print("Enter Username: ");
        String userCredentials = input.nextLine();

        System.out.print("Enter Password: ");
        String accessPass = input.nextLine();

        if (userCredentials.equals(this.username) && accessPass.equals(this.password)) {
            System.out.println("Welcome " + this.name + " " + this.surname + ", it is great to see you again");
        } else {
            System.out.println("Username or password incorrect");
        }
    }

    // Validation methods
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8;
    }

    public boolean checkCellPhoneNumber(String numberPhone) {
        return numberPhone.startsWith("+27") && numberPhone.length() <= 13;
    }

    // Close scanner when done
    public void closeScanner() {
        input.close();
    }

    // Main method to run registration and login
    public static void main(String[] args) {
        AppLOGIN app = new AppLOGIN();
        app.register();
        app.login();
        app.closeScanner();
    }
}

package com.mycompany.chatappprog;

import java.util.Scanner;

public class ChatAppProg {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ---- Registration ----
        System.out.println("\n---- Registration ----");

        System.out.print("Enter your Name: ");
        String name = input.nextLine();

        System.out.print("Enter your Surname: ");
        String surname = input.nextLine();

        // Username Validation
        String username;
        while (true) {

            System.out.print("Enter your Username: ");
            username = input.nextLine();

            if (checkUsername(username)) {

                System.out.println("Username successfully captured");
                break;

            } else {

                System.out.println(
                        "Username is not correctly formatted, "
                        + "must be at least 5 characters long "
                        + "and include an underscore.");
            }
        }

        // Password Validation
        String password;

        while (true) {

            System.out.print("Enter your Password: ");
            password = input.nextLine();

            if (checkPasswordComplexity(password)) {

                System.out.println("Password successfully captured");
                break;

            } else {

                System.out.println(
                        "Password is not correctly formatted.\n"
                        + "It must contain:\n"
                        + "- At least 8 characters\n"
                        + "- One capital letter\n"
                        + "- One number\n"
                        + "- One special character");
            }
        }

        // Phone Validation
        String phone;

        while (true) {

            System.out.print("Enter Phone Number without +27: ");
            String digits = input.nextLine();

            phone = "+27" + digits;

            if (checkCellPhoneNumber(phone)) {

                System.out.println("Cell phone number successfully added");
                break;

            } else {

                System.out.println("Cell phone number is not correctly formatted.");
            }
        }

        // ---- Login ----
        System.out.println("\n---- Login Now ----");

        while (true) {

            System.out.print("Enter Username: ");
            String userCredentials = input.nextLine();

            System.out.print("Enter Password: ");
            String accessPass = input.nextLine();

            if (userCredentials.equals(username)
                    && accessPass.equals(password)) {

                System.out.println(
                        "Welcome "
                        + name + " "
                        + surname
                        + ", it is great to see you again!");

                break;

            } else {

                System.out.println("Username or password incorrect, try again.");
            }
        }

        // ---- welcome to QuickChat ----
        System.out.println("\nWelcome to QuickChat");

        System.out.print("How many messages would you like to enter: ");
        int numberOfMessages = Integer.parseInt(input.nextLine());

        // Message Loop
        for (int i = 1; i <= numberOfMessages; i++) {

            System.out.println("\nChoose an option:");
            System.out.println("1) Send Message");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print("Enter choice: ");
            String choice = input.nextLine();

            // ---- SEND MESSAGE ----
            if (choice.equals("1")) {

                // Recipient Number
                System.out.print("Enter recipient phone number +27 ");
                String recipientPhone = input.nextLine();

                if (!checkCellPhoneNumber(recipientPhone)) {
  
                    System.out.println(" phone number successfully entered.");
                    i--;
                }else{
                    System.out.println("Incorrect phone number");
                    continue;
                }

                // Users Output
                System.out.print("Enter your message: ");
                String message = input.nextLine();

                if (message.length() > 250) {

                    System.out.println(
                            "Message is too long! "
                            + "Keep it under 250 characters.");

                    i--;
                    continue;
                }

                // JSON Output
                String jsonMessage = "{"
                        + "\"Username\":\"" + username + "\","
                        + "\"phone\":\"" + recipientPhone + "\","
                        + "\"message\":\"" + message + "\""
                        + "}";

                System.out.println("\nJSON Output:");
                System.out.println(jsonMessage);

                // Message Hash
                String[] words = message.split(" ");

                String firstWord = words[0];
                String lastWord = words[words.length - 1];

                String hash = (
                        recipientPhone.substring(0, 3)
                        + ":" + i
                        + ":" + firstWord
                        + lastWord
                ).toUpperCase();

                System.out.println("\nMessage Hash: " + hash);

                // Main menu
                System.out.println("\nWhat do you want to do?");
                System.out.println("1) Send");
                System.out.println("2) Disregard");
                System.out.println("3) Store");

                System.out.print("Your action: ");
                String action = input.nextLine().toLowerCase();

                if (action.equals("send") || action.equals("1")) {

                    System.out.println("\nMessage successfully sent!");
                    System.out.println("To: " + recipientPhone);
                    System.out.println("Message: " + message);
                    System.out.println("Hash: " + hash);

                } else if (action.equals("disregard") || action.equals("2")) {

                    System.out.println("Message deleted.");

                } else if (action.equals("store") || action.equals("3")) {

                    System.out.println("Message successfully stored.");

                } else {

                    System.out.println("Unknown action. Message disregarded.");
                }

            }
            // ---- SHOW RECENT MESSAGES ----
            else if (choice.equals("2")) {

                System.out.println("Coming Soon!");

            }
            // ---- QUIT ----
            else if (choice.equals("3")) {

                System.out.println("Goodbye!");
                break;

            }
            // ---- INVALID ----
            else {

                System.out.println("Invalid choice. Try again.");
                i--;
            }
        }

        System.out.println("\nAll done! Thanks for using QuickChat.");

        input.close();
    }

    // Username Validation
    public static boolean checkUsername(String username) {

        return username.contains("_")
                && username.length() >= 5;
    }

    // Password Validation
    public static boolean checkPasswordComplexity(String password) {

        return password.matches(
                "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$"
        );
    }

    // Phone Validation
    public static boolean checkCellPhoneNumber(String numberPhone) {

        return numberPhone.matches("^\\+27\\d{9}$");
    }
}
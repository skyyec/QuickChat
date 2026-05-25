package com.mycompany.chatapp;

public class MessageClass {

    private final String messageID;
    private final String recipient;
    private final String message;
    private final int messageNumber;

    static int totalMessages = 0;

    // Constructor
    public MessageClass(String messageID, String recipient,
                        String message, int messageNumber) {

        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber;

        totalMessages++;
    }

    // Check Message ID
    public boolean checkMessageID() {
        return messageID.length() == 10;
    }

    // Check Recipient Cell
    public boolean checkRecipientCell() {
        return recipient.startsWith("+27") && recipient.length() == 12;
    }

    // Check Message Length
    public boolean checkMessageLength() {
        return message.length() <= 250;
    }

    // Create Message Hash
    public String createMessageHash() {

        String firstTwo =
                message.substring(0, Math.min(2, message.length())).toUpperCase();

        return messageID + ":" + firstTwo;
    }

    // Send Messages
    public String sentMessages(String option) {
        return "Message sent to " + recipient + ": " + message;
    }

    // Print Messages
    public String printMessages() {

        return "Message ID: " + messageID
                + " | To: " + recipient
                + " | Message: " + message;
    }

    // Return Total Messages
    public int returnTotalMessages() {
        return totalMessages;
    }
}
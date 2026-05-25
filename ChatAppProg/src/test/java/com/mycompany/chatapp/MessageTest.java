package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    MessageClass message1 = new MessageClass(
            "0012345678",
            "+27718693002",
            "Hi Mike can you join us for dinner tonight",
            0
    );

    // Correct Tests

    @Test
    public void testMessageID() {

        System.out.println("MESSAGE ID TEST");

        assertTrue(message1.checkMessageID(),
                "Message ID should be valid");
    }

    @Test
    public void testRecipientCell() {

        System.out.println("RECIPIENT TEST");

        assertTrue(message1.checkRecipientCell(),
                "Recipient phone number should be valid");
    }

    @Test
    public void testMessageLength() {

        System.out.println("MESSAGE LENGTH TEST");

        assertTrue(message1.checkMessageLength(),
                "Message length should be valid");
    }

    @Test
    public void testMessageHash() {

        System.out.println("MESSAGE HASH TEST");

        assertNotNull(message1.createMessageHash(),
                "Hash should not be null");
    }

    @Test
    public void testSentMessages() {

        System.out.println("SEND MESSAGE TEST");

        assertNotNull(message1.sentMessages("send"),
                "Sent message should not be null");
    }

    @Test
    public void testPrintMessages() {

        System.out.println("PRINT MESSAGE TEST");

        assertNotNull(message1.printMessages(),
                "Printed message should not be null");
    }

    @Test
    public void testReturnTotalMessages() {

        System.out.println("TOTAL MESSAGES TEST");

        assertTrue(message1.returnTotalMessages() >= 1,
                "Total messages should be >= 1");
    }

    // ==========================
    // Failed Tests (Incorrect Data)
    // ==========================

    @Test
    public void testFailedMessageID() {

        MessageClass message2 = new MessageClass(
                "1234567891111",
                "08575975889",
                "Hello",
                1
        );

        System.out.println("FAILED MESSAGE ID TEST");

        assertFalse(message2.checkMessageID(),
                "Message ID should be invalid");
    }

    @Test
    public void testFailedMessageLength() {

        String longMessage =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        MessageClass message3 = new MessageClass(
                "0011223344",
                "+27718693002",
                longMessage,
                2
        );

        System.out.println("FAILED MESSAGE LENGTH TEST");

        assertFalse(message3.checkMessageLength(),
                "Message length should be invalid");
    }
}
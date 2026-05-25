/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatappprog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class AppLOGINTest {
    

    private AppLOGIN app;

    @BeforeEach
    public void setUp() {
        // Initialize AppLOGIN instance before each test
        app = new AppLOGIN();
    }

    // Accurate Username if it contains "_" and is 5 characters or less
    @Test
    public void testUsernameCorrect() {
        assertTrue(app.checkUsername("ky1_1"), "Username should be valid");
    }

    // Incorrect username if there is no underscore and is more than 5 characters long 
    @Test
    public void testUsernameIncorrect() {
        assertFalse(app.checkUsername("kyle!!!!!"), "Username should be invalid");
    }

    // Correct password if it has 8 or more characters 
    @Test
    public void testPasswordCorrect() {
        assertTrue(app.checkPasswordComplexity("ch&&sec@k99"), "Password should be valid");
    }

    // Incorrect password if it has less than 8 characters
    @Test
    public void testPasswordIncorrect() {
        String password = "short"; // short password
        assertFalse(app.checkPasswordComplexity(password), "Password should be invalid");
    }

    // Well constructed cellphone number if it starts with "+27"
    @Test
    public void testCellPhoneCorrect() {
        assertTrue(app.checkCellPhoneNumber("+27676785808"), "Cell number should be valid");
    }

    // Poorly constructed cellphone number if it does not start with "+27"
    @Test
    public void testCellPhoneIncorrect() {
        assertFalse(app.checkCellPhoneNumber("08966553"), "Cell number should be invalid");
    }
}
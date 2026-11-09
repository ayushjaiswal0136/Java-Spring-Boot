
package com.ayush.journey;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PasswordCheckerTest {

    @Test
    void acceptsStrongPassword() {
        assertTrue(PasswordChecker.isStrong("Welcome123"));
    }

    @Test
    void rejectsPasswordWithLessThanEightCharacters() {
        assertFalse(PasswordChecker.isStrong("Abc123"));
    }

    @Test
    void rejectsPasswordWithoutDigit() {
        assertFalse(PasswordChecker.isStrong("WelcomeABC"));
    }

    @Test
    void rejectsPasswordWithoutUppercase() {
        assertFalse(PasswordChecker.isStrong("welcome123"));
    }

    @Test
    void rejectsNullPassword() {
        assertFalse(PasswordChecker.isStrong(null));
    }
}

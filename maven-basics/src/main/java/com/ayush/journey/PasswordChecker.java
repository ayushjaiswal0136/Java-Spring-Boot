
package com.ayush.journey;

import org.apache.commons.lang3.StringUtils;

public class PasswordChecker {

    public static boolean isStrong(String password) {

        if (StringUtils.isBlank(password)) {
            return false;
        }

        boolean hasMinimumLength = password.length() >= 8;

        boolean hasDigit = password.matches(".*\\d.*");

        boolean hasUppercase = password.matches(".*[A-Z].*");

        return hasMinimumLength && hasDigit && hasUppercase;
    }
}

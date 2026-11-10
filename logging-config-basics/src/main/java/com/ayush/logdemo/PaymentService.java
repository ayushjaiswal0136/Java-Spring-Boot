package com.ayush.logdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentService {

    // One logger per class, named after the class. static final by convention.
    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    public void pay(String user, double amount) {
        log.debug("pay() called user={} amount={}", user, amount);
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be positive: " + amount);
            }
            log.info("Payment of {} accepted for {}", amount, user);
        } catch (IllegalArgumentException e) {
            // Exception goes LAST and is not matched by a {}: Logback prints the full stack trace
            log.error("Payment failed for user {}", user, e);
        }
    }
}
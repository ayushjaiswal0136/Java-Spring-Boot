package com.ayush.logdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoggingDemo {

    private static final Logger log = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {

        // 1. All five levels
        log.trace("TRACE: very detailed, usually off");
        log.debug("DEBUG: developer details");
        log.info("INFO: normal business event");
        log.warn("WARN: something unusual, app continues");
        log.error("ERROR: something failed");

        // 2. Parameterized message: {} is replaced in order
        String user = "alice";
        int attempts = 3;
        log.info("User {} logged in after {} attempts", user, attempts);

        // 3. MDC: tag every line for this "request", then ALWAYS clear it
        MDC.put("requestId", "req-42");
        try {
            log.info("Handling request");
            PaymentService payments = new PaymentService();
            payments.pay("alice", 500.0);
            payments.pay("bob", -5.0);          // fails: stack trace is logged
        } finally {
            MDC.clear();
        }

        log.info("Done");
    }
}
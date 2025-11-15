package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {

	public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(LogTest.class);
        // System.out.println(new LogTest().getGreeting());
        logger.debug("Logging tests");
        System.out.println("Hello World");
    }
}

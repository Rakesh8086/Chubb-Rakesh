package com.app.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Log4j2 is working!");
        logger.error("This is an error message.");
        try {
            int a = 10;
            int b = 0;
            int result = a / b; 

            logger.info("Result: {}", result);

        } catch (ArithmeticException ex) {
            logger.error("Divide by zero encountered: {}", ex.getMessage());
        }
    }
}
package com.pluralsight.javacoreplatform;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class JavaLogging {
    public static void main(String[] args) {
        LogManager lm = LogManager.getLogManager();

        Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.log(Level.INFO, "My first log message");
        logger.log(Level.INFO, "Another message");
    }
}

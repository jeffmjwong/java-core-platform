package com.pluralsight.javacoreplatform;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaLogging {
    static Logger logger = Logger.getLogger("com.pluralsight");

    public static void main(String[] args) {
        Handler h = new ConsoleHandler();
    }
}

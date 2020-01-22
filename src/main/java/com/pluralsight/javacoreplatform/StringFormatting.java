package com.pluralsight.javacoreplatform;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
        try {
            doWrite(10, 8, 5, 3, 6.5);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void doWrite(int david, int dawson, int dillon, int gordon, double avgDiff) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("myFile.txt"));

        try (Formatter f = new Formatter(writer)) {
            f.format("My nephews are %d, %d, %d and %d years old", david, dawson, dillon, gordon);
            f.format("The average age between each is %.1f years", avgDiff);
        }
    }
}

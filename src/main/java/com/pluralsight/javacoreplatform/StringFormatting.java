package com.pluralsight.javacoreplatform;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
//        doWrite(10, 8, 5, 3, 6.5);
        String s1 = "apple, apple and orange please";
        List<String> strings = Arrays.asList(s1.split("\\b"));
        for (String thePart : strings) {
            if (thePart.matches("apple")) {
                System.out.println(thePart);
            }
        }
    }

    private static void doWrite(int david, int dawson, int dillon, int gordon, double avgDiff) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("myFile.txt"));

            try (Formatter f = new Formatter(writer)) {
                f.format("My nephews are %d, %d, %d and %d years old", david, dawson, dillon, gordon);
                f.format("The average age between each is %.1f years", avgDiff);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

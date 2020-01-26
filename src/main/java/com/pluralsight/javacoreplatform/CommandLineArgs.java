package com.pluralsight.javacoreplatform;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommandLineArgs {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Hello Java no arguments!");
        } else {
            for (String word : args) {
                System.out.println(word);
            }
        }
    }

    private static void showFileLines(String filename) {
        System.out.println();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}

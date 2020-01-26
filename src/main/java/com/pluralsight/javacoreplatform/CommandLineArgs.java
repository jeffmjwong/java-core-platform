package com.pluralsight.javacoreplatform;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommandLineArgs {
    public static void main(String[] args) {
        if (args.length == 0) {
            showUsage();
        }

        String filename = args[0];
        if (!Files.exists(Paths.get(filename))) {
            System.out.println("\n File not found: " + filename);
        }

        showFileLines(filename);
    }

    private static void showFileLines(String filename) {
        System.out.println();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static void showUsage() {
        System.out.println();
        System.out.println("Please provide the filename to process on the command line!");
    }
}

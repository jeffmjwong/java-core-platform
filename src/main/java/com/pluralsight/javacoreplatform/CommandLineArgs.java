package com.pluralsight.javacoreplatform;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class CommandLineArgs {
    public static void main(String[] args) {
//        if (args.length == 0) {
//            showUsage();
//            return;
//        }
//
//        String filename = args[0];
//        if (!Files.exists(Paths.get(filename))) {
//            System.out.println("\n File not found: " + filename);
//            return;
//        }
//
//        showFileLines(filename);

//        Properties props = new Properties();
//        props.setProperty("displayName", "Jim Wilson");
//        props.setProperty("accountNumber", "123-45-6789");
//
//        try (Writer writer = Files.newBufferedWriter(Paths.get("xyz.properties"))) {
//            props.store(writer, "My comment");
//        } catch (Exception e) {
//            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
//        }

        Properties props = new Properties();

        try (Reader reader = Files.newBufferedReader(Paths.get("myapp.properties"))) {
            props.load(reader);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        String val1 = props.getProperty("val1");
        System.out.println(val1);
        String val2 = props.getProperty("val2");
        System.out.println(val2);
        String val3 = props.getProperty("val3");
        System.out.println(val3);
        String val4 = props.getProperty("val4");
        System.out.println(val4);
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

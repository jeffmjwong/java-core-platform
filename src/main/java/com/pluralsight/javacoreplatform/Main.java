package com.pluralsight.javacoreplatform;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
//        doTryCatchFinally();
//        doTryWithResources();
//        doTryWithResourcesMulti();
//        doCloseThing();
        String[] data = { "Line 1", "Line 2 2", "Line 3 3 3" };
        writeData(data);
    }

    private static void writeData(String[] data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("text1.txt"))) {
            for (String d : data) {
                bw.write(d);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void doTryCatchFinally() {
        char[] buff = new char[8];
        int length;
        Reader reader = null;

        try {
            reader = Helper.openReader("/file1.txt");
            while ((length = reader.read(buff)) != -1) {
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception!! - " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e2) {
                System.out.println(e2.getClass().getSimpleName() + " - " + e2.getMessage());
            }
        }
    }

    private static void doTryWithResources() {
        char[] buff = new char[8];
        int length;

        try (Reader reader = Helper.openReader("/file1.txt")) {
            while ((length = reader.read(buff)) != -1) {
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception!! - " + e.getMessage());
        }
    }

    private static void doTryWithResourcesMulti() {
        char[] buff = new char[8];
        int length;

        try (Reader reader = Helper.openReader("/file1.txt"); Writer writer = Helper.openWriter("file2.txt")) {
            while ((length = reader.read(buff)) != -1) {
                System.out.println("\nlength: " + length);
                writer.write(buff);
                for (int i = 0; i < length; i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception!! - " + e.getMessage());
        }
    }

    private static void doCloseThing() {
        try (MyAutoCloseable ac = new MyAutoCloseable()) {
            ac.saySomething();
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

            for (Throwable t : e.getSuppressed()) {
                System.out.println("Surpressed: " + t.getMessage());
            }
        }
    }
}

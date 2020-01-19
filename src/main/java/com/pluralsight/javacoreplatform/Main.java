package com.pluralsight.javacoreplatform;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
//        doTryCatchFinally();
//        doTryWithResources();
//        doTryWithResourcesMulti();

    }

    public static void doTryCatchFinally() {
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

    public static void doTryWithResources() {
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

    public static void doTryWithResourcesMulti() {
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
}

package com.pluralsight.javacoreplatform;

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
    }
}

package com.pluralsight.javacoreplatform;

import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
//        int david = 13, dawson = 11, dillon = 4, gordon = 2;
//        String s1 = String.format("My nephews are %#X, %#X, %#X and %#X years old", david, dawson, dillon, gordon);
//        System.out.println(s1);

        String s1 = String.format("W:%04d X:%04d", 5, 235);
        String s2 = String.format("Y:%04d Z:%04d", 481, 12);
        System.out.println(s1);
        System.out.println(s2);
    }
}

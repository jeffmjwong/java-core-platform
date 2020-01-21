package com.pluralsight.javacoreplatform;

import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
//        int david = 13, dawson = 11, dillon = 4, gordon = 2;
//        String s1 = String.format("My nephews are %#X, %#X, %#X and %#X years old", david, dawson, dillon, gordon);
//        System.out.println(s1);

        String s1 = String.format("W:%4d X:%4d", 5, 235);
        String s2 = String.format("Y:%4d Z:%4d", 481, 12);
        System.out.println(s1);
        System.out.println(s2);
    }
}

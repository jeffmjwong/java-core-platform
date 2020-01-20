package com.pluralsight.javacoreplatform;

import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
        double david = 13, dawson = 11, dillon = 4, gordon = 2;
        String s1 = String.format("My nephews are %.2f, %.2f, %.2f and %.2f years old", david, dawson, dillon, gordon);
        System.out.println(s1);
    }
}

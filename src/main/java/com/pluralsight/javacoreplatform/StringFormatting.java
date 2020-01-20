package com.pluralsight.javacoreplatform;

import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
        int david = 13, dawson = 11, dillon = 4, gordon = 2;
        String s1 = String.format("My nephews are %d, %d, %d and %d years old", david, dawson, dillon, gordon);
        System.out.println(s1);
    }
}

package com.pluralsight.javacoreplatform;

import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
        String s1 = String.format("%2$d %<04d %1$d", 100, 200, 300);
        System.out.println(s1);
    }
}

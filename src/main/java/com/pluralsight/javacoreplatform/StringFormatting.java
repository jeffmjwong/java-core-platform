package com.pluralsight.javacoreplatform;

import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        sj.setEmptyValue("EMPTY");

        String result = sj.toString();

        System.out.println(result);
    }
}

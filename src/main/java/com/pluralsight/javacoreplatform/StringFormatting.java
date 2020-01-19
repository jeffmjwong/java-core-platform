package com.pluralsight.javacoreplatform;

import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(", ");

        sj.add("alpha");
        sj.add("beta");
        sj.add("delta");

        String result = sj.toString();

        System.out.println(result);
    }
}

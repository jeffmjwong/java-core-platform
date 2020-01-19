package com.pluralsight.javacoreplatform;

import java.util.StringJoiner;

public class StringFormatting {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner(", ", "3 types of rays - ", " hmmm");

        sj.add("alpha").add("beta").add("delta");

        String result = sj.toString();

        System.out.println(result);
    }
}

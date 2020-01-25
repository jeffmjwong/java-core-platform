package com.pluralsight.javacoreplatform;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Collections {
    public static void main(String[] args) {
        Set<MyClass> tree = new TreeSet<>(new MyComparator());

        tree.add(new MyClass("bbb", "b"));
        tree.add(new MyClass("aaa", "d"));
        tree.add(new MyClass("ddd", "a"));
        tree.add(new MyClass("ggg", "c"));
        tree.add(new MyClass("eee", "e"));
        tree.add(new MyClass("ccc", "g"));
        tree.add(new MyClass("fff", "f"));

        tree.forEach(System.out::println);

        Map<String, String> map = new HashMap<>();

        map.put("111", "abc");
        map.put("222", "def");
        map.put("333", "ghi");

        map.replaceAll((k, v) -> v.toUpperCase() + k);
        map.forEach((k, v) -> System.out.println(k + " | " + v));
    }
}

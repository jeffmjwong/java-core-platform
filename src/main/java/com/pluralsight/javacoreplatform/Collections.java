package com.pluralsight.javacoreplatform;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Collections {
    public static void main(String[] args) {
//        Set<MyClass> tree = new TreeSet<>(new MyComparator());
////
////        tree.add(new MyClass("bbb", "b"));
////        tree.add(new MyClass("aaa", "d"));
////        tree.add(new MyClass("ddd", "a"));
////        tree.add(new MyClass("ggg", "c"));
////        tree.add(new MyClass("eee", "e"));
////        tree.add(new MyClass("ccc", "g"));
////        tree.add(new MyClass("fff", "f"));
////
////        tree.forEach(System.out::println);

        SortedMap<Integer, String> map = new TreeMap<>();

        map.put(68192, "ghi");
        map.put(25511, "abc");
        map.put(92210, "ghi");
        map.put(15592, "def");
        map.put(51288, "ghi");
        map.put(39912, "ghi");

        map.forEach((k, v) -> System.out.println(k + " | " + v));
    }
}

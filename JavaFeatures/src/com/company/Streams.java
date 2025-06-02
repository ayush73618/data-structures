package com.company;

import java.util.Arrays;

public class Streams {
    public static void main(String[] args) {
        String str[] = {"Ayush","Sharma","Shivam","Sharma","rohit","Shubham","Rohit"};

        Arrays.stream(str).distinct().filter(name->name.startsWith("S") || name.startsWith("R")||name.startsWith("r")|| name.startsWith("s")).map(name->name.toLowerCase()).sorted().forEach(System.out::println);
    }
}

package com.povazhnukvv;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Main {

    static Map<String, BinaryOperator<Integer>> operators = new HashMap<>();

    static {
        operators.put("add", (a,b) -> a+b);
        operators.put("substract", (a,b) -> a-b);
        operators.put("multiply", (a,b) -> a*b);
        operators.put("divide", (a,b) -> a/b);
    }

    public static int arithmetic(int a, int b, String operator) {
        return arithmetic(a,b,operators.get(operator));
    }

    public static Integer arithmetic(int a, int b, BinaryOperator<Integer> operator) {
        return Optional.ofNullable(operator).orElse((x,y)->0).apply(a,b);
    }

    public static void main(String[] args) {
        System.out.println(arithmetic(1,2,"add"));
    }
}

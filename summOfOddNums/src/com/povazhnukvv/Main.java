package com.povazhnukvv;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static boolean isOdd(int num) {
      return num % 2 != 0;
    }
    public static int cubeOdd(int[] arr) {
        switch (arr[0]) {
            case 1:

        }
        return Arrays.stream(arr)
                .filter(Main::isOdd)
                .map(num-> num*num*num)
                .sum();

    }
    public static void main(String[] args) {
        System.out.println(cubeOdd(new int[]{1,2,3,4}));
    }
}

package io.huhu.algorithm.demo.recursion;

import java.util.Arrays;

/**
 * 生成斐波那契数列
 */
public class Fibonacci {

    public static int fn(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fn(n - 1) + fn(n - 2);
    }

    public static void main(String[] args) {
        int n = 20;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fn(i + 1);
        }
        System.out.println(Arrays.toString(arr));
    }

}

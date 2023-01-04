package io.huhu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 5, 2, 3, 1};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int k = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > k) a[j + 1] = a[j--];
            a[j + 1] = k;
        }
    }

}

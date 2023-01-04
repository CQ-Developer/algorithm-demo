package io.huhu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 实现选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 从未排序的区间中找到最小的元素
     * 放到未排序区间的头部
     */
    public static void sort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            // 找到未排序区间最小值的下标
            int m = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[m]) {
                    m = j;
                }
            }
            // 将未排序区间的最小值
            // 和未排序区间的第一个元素交换
            if (i != m) {
                int t = a[i];
                a[i] = a[m];
                a[m] = t;
            }
        }
    }

}

package io.huhu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 实现选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int... arr) {
        if (arr.length <= 1) {
            return;
        }
        // 循环n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            // 查找min
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }
            // 交换元素
            int tmp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = tmp;
        }
    }

}

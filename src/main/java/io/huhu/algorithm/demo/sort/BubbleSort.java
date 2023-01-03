package io.huhu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int... arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; ++i) {
            // 提前退出循环的标记位
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            // 没有数据交换提前退出
            if (!flag) {
                break;
            }
        }
    }

}

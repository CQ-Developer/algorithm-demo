package io.huhu.algorithm.demo.sort;

import io.huhu.CommonUtils;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = CommonUtils.generateArray(20);
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int s, int e) {
        if (s < e) {
            int l = s;
            int num = arr[l];
            int r = e;
            while (l < r) {
                while (l < r && arr[r] >= num) {
                    r--;
                }
                if (l < r) {
                    arr[l] = arr[r];
                }
                while (l < r && arr[l] <= num) {
                    l++;
                }
                if (l < r) {
                    arr[r] = arr[l];
                }
                if (l >= r) {
                    arr[l] = num;
                }
            }
            sort(arr, s, r - 1);
            sort(arr, r + 1, e);
        }
    }

}

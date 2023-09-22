package io.huhu.algorithm.demo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[30];
        var rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1000);
        }
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int pivot = arr[left];
        int right = end;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left >= right) {
                arr[left] = pivot;
            }
        }
        sort(arr, start, right - 1);
        sort(arr, right + 1, end);
    }

}

package io.huhu.algorithm.demo.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 6, 3, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int... arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        split(arr, 0, arr.length - 1);
    }

    private static void split(int[] arr, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = (tail + head) / 2;
        split(arr, head, mid);
        split(arr, mid + 1, tail);
        merge(arr, head, mid, tail);
    }

    private static void merge(int[] arr, int head, int mid, int tail) {
        int[] tmp = new int[tail - head + 1];
        int i = head;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= tail) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= tail) {
            tmp[k++] = arr[j++];
        }
        System.arraycopy(tmp, 0, arr, head, k);
    }

}

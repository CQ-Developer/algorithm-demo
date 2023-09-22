package io.huhu.algorithm.gokking.algorithms;

/**
 * 分治策略 - 分而治之 - divide and conquer<br>
 * 这是一种解决问题的思路，并不是某种具体的算法，因此它具备通用性。
 */
public final class QuickSort {

    private QuickSort() {}

    /**
     * 快速排序算法<br>
     * 采用了分治的思想。<br>
     * 最差：O(n<sup>2</sup>)<br>
     * 最好：O(n*Log<sub>2</sub>n)
     */
    public static void sort(int[] arr) {
        if (arr != null && arr.length > 1) {
            sort(arr, 0, arr.length - 1);
        }
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int pivot = arr[start];
        int right = end;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, start, right);
        sort(arr, start, right - 1);
        sort(arr, left + 1, end);
    }

    private static void swap(int[] arr, int left, int right) {
        if (left != right) {
            int i = arr[left];
            arr[left] = arr[right];
            arr[right] = i;
        }
    }

}

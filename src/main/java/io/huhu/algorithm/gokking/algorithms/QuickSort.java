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
     *
     * @param arr 待排序的数组
     */
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int p = 0;
        int pivot = arr[p];
        int[] less = findLess(arr, p, pivot);
        int[] greater = findGreater(arr, p, pivot);
        return concat(sort(less), pivot, sort(greater));
    }

    private static int[] concat(int[] less, int p, int[] greater) {
        int[] result = new int[less.length + 1 + greater.length];
        int n = 0;
        for (int i : less) {
            result[n++] = i;
        }
        result[n++] = p;
        for (int i : greater) {
            result[n++] = i;
        }
        return result;
    }

    private static int[] findGreater(int[] arr, int p, int pivot) {
        int len = 0;
        int[] greater = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i != p && arr[i] >= pivot) {
                greater[len++] = arr[i];
            }
        }
        int[] result = new int[len];
        System.arraycopy(greater, 0, result, 0, len);
        return result;
    }

    private static int[] findLess(int[] arr, int p, int pivot) {
        int len = 0;
        int[] less = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i != p && arr[i] < pivot) {
                less[len++] = arr[i];
            }
        }
        int[] result = new int[len];
        System.arraycopy(less, 0, result, 0, len);
        return result;
    }

}

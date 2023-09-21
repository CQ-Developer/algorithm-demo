package io.huhu.algorithm.gokking.algorithms;

public final class SelectionSort {

    private SelectionSort() {}

    /**
     * 选择排序<br>
     * 时间复杂度<b>O(n<sup>2</sup>)</b>
     *
     * @param arr 数组
     * @return 升序排列后的数组
     */
    public static int[] sort(int[] arr) {
        int len = arr == null ? 0 : arr.length;
        int[] sorted = new int[len];
        boolean[] used = new boolean[len];
        for (int i = 0; i < len; i++) {
            int s = findSmallest(arr, used);
            used[s] = true;
            sorted[i] = arr[s];
        }
        return sorted;
    }

    private static int findSmallest(int[] arr, boolean[] used) {
        int smallest = arr[0];
        int s = 0;
        for (int i = 1; i < arr.length; i++) {
            if (!used[i] && arr[i] < smallest) {
                smallest = arr[i];
                s = i;
            }
        }
        return s;
    }

}

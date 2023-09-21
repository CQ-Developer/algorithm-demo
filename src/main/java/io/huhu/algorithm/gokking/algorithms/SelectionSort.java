package io.huhu.algorithm.gokking.algorithms;

public final class SelectionSort {

    private SelectionSort() {}

    /**
     * 选择排序<br>
     * 时间复杂度<b>O(n<sup>2</sup>)</b>
     *
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        int len = arr == null ? 0 : arr.length;
        for (int i = 0; i < len; i++) {
            // 找到当前元素后方的最小元素
            int m = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[m]) {
                    m = j;
                }
            }
            // 交换当前元素和后方的最小元素
            if (i != m) {
                int t = arr[i];
                arr[i] = arr[m];
                arr[m] = t;
            }
        }
    }

}

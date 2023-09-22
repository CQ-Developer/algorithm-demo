package io.huhu.gokking.algorithms;

public final class BubbleSort {

    private BubbleSort() {}

    /**
     * 冒泡排序<br>
     * 时间复杂度<b>O(n<sup>2</sup>)</b>
     *
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        int len = arr == null ? 0 : arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean noChange = true;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    noChange = false;
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
            if (noChange) {
                return;
            }
        }
    }

}

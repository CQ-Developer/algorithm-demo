package io.huhu.algorithm.fourth.Edition;

final class Sort {

    /**
     * 选择排序
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int m = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[m]) {
                    m = j;
                }
            }
            if (m != i) {
                int t = arr[i];
                arr[i] = arr[m];
                arr[m] = t;
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int t = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = t;
            }
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] arr) {
        int h = 1;
        while (h < arr.length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    int t = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = t;
                }
            }
            h /= 3;
        }
    }

}

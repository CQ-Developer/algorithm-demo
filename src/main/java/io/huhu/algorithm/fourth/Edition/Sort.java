package io.huhu.algorithm.fourth.Edition;

final class Sort {

    private Sort() {}

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
            int num = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > num) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = num;
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

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        split(arr, 0, arr.length - 1);
    }

    private static void split(int[] arr, int s, int e) {
        if (s < e) {
            int m = (s + e) >> 1;
            split(arr, s, m);
            split(arr, m + 1, e);
            merge(arr, s, m, e);
        }
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] tmp = new int[e - s + 1];
        int i = s;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= e) {
            tmp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= m) {
            tmp[k++] = arr[i++];
        }
        while (j <= e) {
            tmp[k++] = arr[j++];
        }
        System.arraycopy(tmp, 0, arr, s, k);
    }

}

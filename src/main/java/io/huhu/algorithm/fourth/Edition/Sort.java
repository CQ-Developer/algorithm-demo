package io.huhu.algorithm.fourth.Edition;

final class Sort {

    private Sort() {}

    /**
     * 选择排序
     */
    public static void selectionSort(int[] array) {
        if (array != null && array.length > 1) {
            for (int i = 0; i < array.length; i++) {
                int m = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[m]) {
                        m = j;
                    }
                }
                if (m != i) {
                    int t = array[i];
                    array[i] = array[m];
                    array[m] = t;
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertionSort(int[] array) {
        if (array != null && array.length > 1) {
            for (int i = 1; i < array.length; i++) {
                int num = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] > num) {
                    array[j + 1] = array[j--];
                }
                array[j + 1] = num;
            }
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] array) {
        if (array != null && array.length > 1) {
            int h = 1;
            while (h < array.length / 3) {
                h = 3 * h + 1;
            }
            while (h >= 1) {
                for (int i = h; i < array.length; i++) {
                    for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                        int t = array[j];
                        array[j] = array[j - h];
                        array[j - h] = t;
                    }
                }
                h /= 3;
            }
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] array) {
        if (array != null && array.length > 1) {
            split(array, 0, array.length - 1);
        }
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

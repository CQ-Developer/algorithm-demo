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

    /**
     * 快速排序
     */
    public static void quickSort(int[] array) {
        if (array != null && array.length > 1) {
            quickSort(array, 0, array.length - 1);
        }
    }

    private static void quickSort(int[] a, int s, int e) {
        if (s < e) {
            int l = s;
            int num = a[l];
            int r = e;
            while (l < r) {
                while (l < r && a[r] >= num) {
                    r--;
                }
                if (l < r) {
                    a[l] = a[r];
                }
                while (l < r && a[l] <= num) {
                    l++;
                }
                if (l < r) {
                    a[r] = a[l];
                }
                if (l >= r) {
                    a[l] = num;
                }
            }
            quickSort(a, s, r - 1);
            quickSort(a, r + 1, e);
        }
    }

    /**
     * 3向切分快速排序
     */
    public static void quick3WaySort(int[] array) {
        if (array != null && array.length > 1) {
            quick3WaySort(array, 0, array.length - 1);
        }
    }

    private static void quick3WaySort(int[] arr, int start, int end) {
        if (end > start) {
            int l = start;
            int r = end;
            int i = start + 1;
            int num = arr[start];
            while (i <= r) {
                if (arr[i] < num) {
                    swap(arr, l++, i++);
                } else if (arr[i] > num) {
                    swap(arr, i, r--);
                } else {
                    i++;
                }
            }
            quick3WaySort(arr, start, l - 1);
            quick3WaySort(arr, r + 1, end);
        }
    }

    private static void swap(int[] a, int i, int j) {
        if (i != j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

}

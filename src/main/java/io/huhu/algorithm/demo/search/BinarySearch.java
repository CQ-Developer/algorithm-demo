package io.huhu.algorithm.demo.search;

/**
 * 二分查找
 * <p>
 * 时间复杂度O(logN))
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {15, 16, 23, 31, 35, 36, 40, 47, 49, 54, 59, 63, 68, 69, 87, 94, 96};

        int i = binarySearch(a, 31);
        System.out.println(i);

        int j = binarySearch(a, 0, a.length - 1, 94);
        System.out.println(j);
    }

    /**
     * 基于循环实现的二分查找
     */
    public static int binarySearch(int[] a, int v) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == v) return mid;
            if (a[mid] < v) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * 基于递归实现的二分查找
     */
    public static int binarySearch(int[] a, int low, int high, int v) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == v) return mid;
        if (a[mid] < v) return binarySearch(a, mid + 1, high, v);
        else return binarySearch(a, low, mid + 1, v);
    }

}

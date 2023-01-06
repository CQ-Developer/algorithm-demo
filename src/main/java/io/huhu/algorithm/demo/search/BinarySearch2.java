package io.huhu.algorithm.demo.search;

/**
 * 二分查找变体二
 * 查找最后一个值等于给定值的元素
 * 注意数组是有序的但存在重复的元素
 */
public class BinarySearch2 {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int i = binarySearch(a, 8);
        System.out.println(i);
    }

    /**
     * 参照 {@link BinarySearch1} 的思路
     */
    public static int binarySearch(int[] a, int v) {
        int n = a.length - 1;
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > v) {
                high = mid - 1;
            } else if (a[mid] < v) {
                low = mid + 1;
            } else {
                if (mid == n || a[mid + 1] != v) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}

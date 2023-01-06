package io.huhu.algorithm.demo.search;

/**
 * 二分查找变体四
 * 查找最后一个值小于等于给定值的元素
 */
public class BinarySearch4 {

    public static void main(String[] args) {
        int[] a = {3, 5, 6, 8, 9, 10};
        int i = binarySearch(a, 7);
        System.out.println(i);
    }

    /**
     * 参照 {@link BinarySearch3} 的思路
     */
    public static int binarySearch(int[] a, int v) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > v) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] > v) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}

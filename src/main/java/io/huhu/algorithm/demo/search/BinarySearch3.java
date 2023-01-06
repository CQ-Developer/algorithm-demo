package io.huhu.algorithm.demo.search;

/**
 * 二分查找变体三
 * 查找第一个值大于等于给定值的元素
 */
public class BinarySearch3 {

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 10};
        int i = binarySearch(a, 5);
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
            if (a[mid] >= v) {
                if (mid == 0 || a[mid - 1] < v) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}

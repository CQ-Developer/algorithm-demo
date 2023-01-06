package io.huhu.algorithm.demo.search;

/**
 * 二分查找变体一
 * 查找第一个值等于给定值的元素
 * 注意数组是有序的但存在重复的元素
 */
public class BinarySearch1 {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int i = binarySearch(a, 8);
        System.out.println(i);

        int j = binarySearch1(a, 8);
        System.out.println(j);
    }

    /**
     * 思路:
     * a[mid] > v 表示要查找的数据在低半区 -> high = mid - 1
     * a[mid] < v 表示要查找的数据在高半区 -> low = mid + 1
     * a[mid] = v 表示要查找的数据就是 mid
     * 如果 mid = 0, 那么表示要查找的数据是数组的第一个元素, 直接返回 mid
     * 如果 mid != 0, 判断 mid 的前一位元素是否等于 v, 如果不等于, 那么 mid 就是第一个要查找的元素, 直接返回 mid
     * 如果 mid 的前一位元素也是 v, 表示 mid 不是要查找的第一个元素, mid 的前面还有还有相同的元素
     * 设置 high = mid - 1, 继续查找
     */
    public static int binarySearch(int[] a, int v) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > v) {
                high = mid - 1;
            } else if (a[mid] < v) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != v) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 这种写法更加简单
     * 但是不易理解
     * 推荐上面的写法
     */
    public static int binarySearch1(int[] a, int v) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= v) high = mid - 1;
            else low = mid + 1;
        }
        if (low < a.length && a[low] == v) return low;
        return -1;
    }

}

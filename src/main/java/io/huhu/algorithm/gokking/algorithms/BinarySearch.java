package io.huhu.algorithm.gokking.algorithms;

public final class BinarySearch {

    private BinarySearch() {}

    /**
     * 二分查找法<br>
     * 时间复杂度<b>O(log<sub>2</sub>n)</b>
     *
     * @param arr 升序排序的数组
     * @param t   目标值
     * @return 目标值的下表，返回-1表示不存在
     */
    public static int search(int[] arr, int t) {
        int l = 0;
        int r = arr == null ? -1 : arr.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (arr[m] < t) {
                l = m + 1;
            }
            else if (arr[m] > t) {
                r = m - 1;
            }
            else {
                return m;
            }
        }
        return -1;
    }

}

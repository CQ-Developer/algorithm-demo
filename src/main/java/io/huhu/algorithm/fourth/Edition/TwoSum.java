package io.huhu.algorithm.fourth.Edition;

import java.util.Arrays;

/**
 * 在一个不包含重复元素的数组中，找出2数之和为0的整数对的数量
 */
final class TwoSum {

    private TwoSum() {}

    /**
     * O(N<sup>2</sup>)
     */
    public static int count(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * O(4NlgN)
     */
    public static int countFast(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (Arrays.binarySearch(arr, -arr[i]) > i) {
                count++;
            }
        }
        return count;
    }

}

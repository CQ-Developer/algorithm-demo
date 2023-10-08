package io.huhu.algorithm.fourth.Edition;

import java.util.Arrays;

/**
 * 数组中不存在重复元素，找出三个数相加为零的组合数量。
 */
final class ThreeSum {

    private ThreeSum() {}

    /**
     * O(N<sup>3</sup>)
     */
    public static int count(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    /**
     * O(N<sup>2</sup>lgN)
     */
    public static int countFast(int[] arr) {
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Arrays.binarySearch(arr, -arr[i] - arr[j]) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int countFast2(int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int l = i + 1;
            int r = array.length - 1;
            while (l < r) {
                int sum = array[i] + array[l] + array[r];
                if (sum == 0) {
                    count++;
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }

}

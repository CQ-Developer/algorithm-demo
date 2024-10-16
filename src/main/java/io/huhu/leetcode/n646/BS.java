package io.huhu.leetcode.n646;

import java.util.Arrays;

class BS implements Code {

    /**
     * end保存长度为n的最长数对链的最小结尾
     */
    @Override
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = 0;
        int[] end = new int[pairs.length];
        for (int[] pair : pairs) {
            int i = f(end, n, pair[0]);
            if (i == -1) {
                end[n++] = pair[1];
            } else {
                end[i] = Math.min(end[i], pair[1]);
            }
        }
        return n;
    }

    /**
     * 寻找大于等于num的最左位置
     */
    private int f(int[] nums, int n, int target) {
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[m] >= target) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}

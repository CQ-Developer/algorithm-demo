package io.huhu.leetcode.dynamic.programming.medium.n646;

import java.util.Arrays;

class Greedy implements Solution {

    @Override
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int pre = Integer.MIN_VALUE, ans = 0;
        for (int[] pair : pairs) {
            if (pair[0] > pre) {
                ans++;
                pre = pair[1];
            }
        }
        return ans;
    }

}

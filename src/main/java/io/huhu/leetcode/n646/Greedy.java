package io.huhu.leetcode.n646;

import java.util.Arrays;

class Greedy implements Code {

    @Override
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int pre = Integer.MIN_VALUE, ans = 0;
        for (int[] pair : pairs) {
            if (pair[0] > pre) {
                pre = pair[1];
                ans++;
            }
        }
        return ans;
    }

}

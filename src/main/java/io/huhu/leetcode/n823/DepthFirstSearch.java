package io.huhu.leetcode.n823;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class DepthFirstSearch implements Code {

    private static final int M = 1000000007;

    @Override
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Map<Integer, Integer> map = HashMap.newHashMap(n);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += f(arr, map, i, dp);
        }
        return (int) (ans % M);
    }

    private long f(int[] arr, Map<Integer, Integer> map, int i, long[] dp) {
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
            if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                dp[i] += f(arr, map, j, dp) * f(arr, map, map.get(arr[i] / arr[j]), dp);
            }
        }
        return dp[i];
    }

}

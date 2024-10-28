package io.huhu.leetcode.n873;

import java.util.HashMap;
import java.util.Map;

class DynamicProgramming implements Code {

    @Override
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> table = HashMap.newHashMap(n);
        for (int i = 0; i < n; i++) {
            table.put(arr[i], i);
        }
        int ans = 0;
        int[][] f = new int[n][n];
        for (int k = 0; k < n; k++) {
            for (int j = k - 1; j >= 0 && 2 * arr[j] > arr[k]; j--) {
                int i = table.getOrDefault(arr[k] - arr[j], -1);
                if (i != -1) {
                    f[j][k] = Math.max(f[i][j] + 1, 3);
                }
                ans = Math.max(ans, f[j][k]);
            }
        }
        return ans;
    }

}

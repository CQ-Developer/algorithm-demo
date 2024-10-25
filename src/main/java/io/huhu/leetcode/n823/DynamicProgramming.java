package io.huhu.leetcode.n823;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class DynamicProgramming implements Code {

    private static final int M = 1000000007;

    @Override
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        long ans = 0;
        long[] f = new long[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    f[i] += f[j] * f[map.get(arr[i] / arr[j])];
                }
            }
            ans += f[i];
        }
        return (int) (ans % M);
    }

}

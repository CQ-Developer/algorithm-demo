package io.huhu.leetcode.n1218;

import io.huhu.AC;

import java.util.HashMap;
import java.util.Map;

@AC
class DynamicProgramming implements Code {

    @Override
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> f = HashMap.newHashMap(arr.length);
        for (int num : arr) {
            int max = f.getOrDefault(num - difference, 0) + 1;
            ans = Math.max(ans, max);
            f.put(num, max);
        }
        return ans;
    }

}

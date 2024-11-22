package io.huhu.leetcode.n1477;

import io.huhu.AC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AC
class PrefixSumSlidingWindow implements Code {

    @Override
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = arr.length;
        int[] left = new int[n];
        Arrays.fill(left, n + 1);
        int ans = n + 1;
        for (int i = 0, sum = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                int len = map.get(sum - target);
                left[i] = i - len;
                if (len >= 0) {
                    ans = Math.min(ans, i - len + left[len]);
                }
            }
            if (i > 0) {
                left[i] = Math.min(left[i - 1], left[i]);
            }
            map.put(sum, i);
        }
        return ans < n + 1 ? ans : -1;
    }

}

package io.huhu.leetcode.n2311;

import io.huhu.AC;

import java.util.HashMap;
import java.util.Map;

@AC
class Memoization implements Solution {

    @Override
    public int longestSubsequence(String s, int k) {
        Map<Integer, Integer> mem = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        f(chars, k, n - 1, 0, 0, mem);
        return mem.getOrDefault(-1, 0);
    }

    private void f(char[] s, int k, int i, double num, int len, Map<Integer, Integer> mem) {
        // mem记录到达过i位置的最大长度
        if (mem.containsKey(i) && len <= mem.get(i)) {
            return;
        }
        mem.put(i, len);
        if (i < 0) {
            return;
        }
        if (s[i] == '0') {
            f(s, k, i - 1, num, len + 1, mem);
        } else if (num + Math.pow(2, len) <= k) {
            f(s, k, i - 1, num + Math.pow(2, len), len + 1, mem);
        }
        f(s, k, i - 1, num, len, mem);
    }

}
